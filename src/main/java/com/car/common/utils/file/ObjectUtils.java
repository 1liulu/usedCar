package com.car.common.utils.file;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 工具类
 *
 * @author LiuJinLiang
 * @date 2018/6/5 11:36
 */
public class ObjectUtils {

    public static void checkNotBlank(Object object) throws IllegalArgumentException {
        if (ObjectUtils.isBlank(object)) {
            throw new IllegalArgumentException("参数不能为空");
        }
    }

    public static void checkNotBlank(Object... objects) throws IllegalArgumentException {
        for (Object object : objects) {
            checkNotBlank(object);
        }
    }

    public static boolean isNotBlank(Object object) {
        return !isBlank(object);
    }

    public static boolean isBlank(Object... params) {
        if (params == null || params.length == 0) {
            return true;
        }

        for (Object object : params) {
            if (isBlank(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(Object object) {
        if (object == null) {
            return true;
        }
        //集合
        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            return collection.isEmpty();
        }
        //字符串
        if (object instanceof String) {
            String charSequence = (String) object;
            return charSequence.trim().length() == 0;
        }
        //Map
        if (object instanceof Map) {
            Map map = (Map) object;
            return map.isEmpty();
        }
        //数组
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        //other type
        return false;
    }

    //集合合并
    public static <T> List<T> spliceCollections(List<T> srcList, List<T> tarList) {
        List<T> list = new ArrayList<>();
        if (ObjectUtils.isNotBlank(srcList)) {
            for (T t : srcList) {
                if (list.contains(t)) {
                    continue;
                }
                list.add(t);
            }
        }
        if (ObjectUtils.isNotBlank(tarList)) {
            for (T t : tarList) {
                if (list.contains(t)) {
                    continue;
                }
                list.add(t);
            }
        }
        return list;
    }

    //验证是否是数字
    public static boolean isNumber(Object value) {
        try {
            Long.valueOf(value.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
