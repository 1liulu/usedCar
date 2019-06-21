package com.car.common.utils.file;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class IdWorker {

    private long workerId = 1;
    private long sequence = 0;

    private long twepoch = 1546272000000L;

    private long workerIdBits = 5L;
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long timestampLeftShift = sequenceBits + workerIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    private ReentrantLock lock = new ReentrantLock();

    public IdWorker() {
    }

    public IdWorker(long workerId) {
        this.workerId = workerId;
    }

    public long nextId() {
        lock.lock();
        long timestamp = 0L;
        try {
            timestamp = timeGen();

            if (timestamp < lastTimestamp) {
                System.out.println(lastTimestamp);
                System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                        lastTimestamp - timestamp));
            }

            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & sequenceMask;
                if (sequence == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0;
            }
        } finally {
            lock.unlock();
        }
        System.out.println(1);
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp++;
        }
        return timestamp;
    }

    public long timeGen() {
        return System.currentTimeMillis();
    }

    //随机ID
    public static Long getRandomNextId() {
        int randomWorkId = new Random().nextInt(2 << 4 - 1);
        IdWorker idWorker = new IdWorker(randomWorkId);
        return idWorker.nextId();
    }

    public static void main(String[] args) throws Exception {
        Set<Long> idSet = new HashSet<>();

        IdWorker idWorker = new IdWorker(21);
        int i = 0;
        long s1 = System.currentTimeMillis();
        long s2 = 0L;
        while (i <= 1000000) {
            if (i == 0) {
                System.out.println();
            }
            Long id = idWorker.nextId();
            if (idSet.contains(id)) {
                throw new Exception("重复: " + id);
            } else {
                idSet.add(id);
            }
            if (i % 10000 == 0) {
                s2 = System.currentTimeMillis();
                System.out.println(i + ",耗时: " + (s2 - s1));
                s1 = s2;
            }
            i++;
        }
    }
}