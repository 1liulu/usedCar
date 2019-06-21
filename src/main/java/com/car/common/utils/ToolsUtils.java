package com.car.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/***
 * 通用工具类
 */
public class ToolsUtils {
    public static String getOrdersId(String title){
        return title+collectionsNum(DateUtils.dateTime()+getRandomNum(5));
    }
    public static String collectionsNum(String strNum){
        char [] str=strNum.toCharArray();
        List<String> randRum=new ArrayList<String>();
        for(int i=0;i<str.length;i++){
            randRum.add(String.valueOf(str[i]));
        }
        Collections.shuffle(randRum);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<randRum.size();i++){
            sb.append(randRum.get(i));
        }
        return sb.toString().trim();
    }

    //获取随机数字
    public static String getRandomNum(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(10);// [0,62)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
