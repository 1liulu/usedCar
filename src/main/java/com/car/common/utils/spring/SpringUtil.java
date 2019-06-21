package com.car.common.utils.spring;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author 王尧 【wangyao@ihooyah.com】
 * @description
 * @create 2018-04-20 上午10:35
 **/
public class SpringUtil {
    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);

    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 获取布尔值
     *
     * @return
     * @author 王尧 【wangyao@ihooyah.com】
     * @date 2018/4/20 上午10:37
     **/
    public static boolean getBooleanValue(String properties) {
        String value = getApplicationContext().getEnvironment().getProperty(properties);
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        boolean result = Boolean.valueOf(value);
        return result;
    }

    /**
     * 获取Int值
     *
     * @return
     * @author 王尧 【wangyao@ihooyah.com】
     * @date 2018/4/20 上午10:40
     **/
    public static int getIntegerValue(String properties) {
        String value = getApplicationContext().getEnvironment().getProperty(properties);
        if (StringUtils.isEmpty(value)) {
            return -1;
        }
        int result = Integer.parseInt(value);
        return result;
    }

    /**
     * 获取Long值
     *
     * @return
     * @author 王尧 【wangyao@ihooyah.com】
     * @date 2018/4/20 上午10:40
     **/
    public static Long getLongValue(String properties) {
        String value = getApplicationContext().getEnvironment().getProperty(properties);
        if (StringUtils.isEmpty(value)) {
            return -1L;
        }
        Long result = Long.parseLong(value);
        return result;
    }

    /**
     * 获取属性值
     *
     * @return
     * @author 王尧 【wangyao@ihooyah.com】
     * @date 2018/4/20 上午10:40
     **/
    public static String getValue(String properties) {
        String value = getApplicationContext().getEnvironment().getProperty(properties);
        return value;
    }
}
