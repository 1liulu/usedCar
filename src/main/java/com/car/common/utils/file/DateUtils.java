package com.car.common.utils.file;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: matengfei
 * @Date: Created in 16:16 2018/1/4
 */
@Slf4j
public class DateUtils {
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYMMDD = "yyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    //获得距离今天24点还有多少毫秒
    public static Long getCountdown(){
        Calendar c = Calendar.getInstance();
        long now = c.getTimeInMillis();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long millis = c.getTimeInMillis() - now;
        return millis;
    }

    public static void main(String[] args){
        Long countdown = DateUtils.getCountdown();
        System.out.print(countdown);
    }
    /**
     * 时间转字符串
     */
    public static String dateToString(Date date, String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }catch (Exception e){
            log.error("dateToString方法转换日期失败：" + e.getMessage());
            return null;
        }
    }


    /**
     * 字符串转时间
     */
    public static Date stringToDate(String dateStr,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        }catch (Exception e){
            log.error("stringToDate方法转换日期失败：" + e.getMessage());
            return null;
        }
    }


    /**
     * 获取N天前的时间
     */
    public static Date getDateBeforeDays(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        return calendar.getTime();
    }


    /**
     * 获取date当天0点时间
     * @param date
     * @return
     */
    public static Date getDayBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取date当天24点时间
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}
