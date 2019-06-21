package com.car.project.wx.user.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //过期时间365day
    private static final long EXPIER_TIME=365*24*60*60*1000;

    //加密证书
    private static String TOKEN_SERCET ="1234567890QWERTYUIOASDFGHJKLUYHGVRFGHBNMSDERTFVBNMqwertyuiopasdfghjkl";

    /**
     *生成签名，365day过期
     * @param userId 用户id
     * @param openid openid
     * @return
     */
    public static String sgin(String userId,String openid){
        try {
            /** 过期时间*/
            Date date=new Date(System.currentTimeMillis()+EXPIER_TIME);
            /**加密算法*/
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SERCET);
            Map<String,Object> map=new HashMap<>();
            map.put("userId",userId);
            map.put("openid",openid);
            return JWT.create()
                    .withClaim("userId",userId)
                    .withClaim("openid",openid)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
