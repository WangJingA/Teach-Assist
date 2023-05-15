package com.boot.teach.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Map;


public class JWTUtils {
    @Value("${JWT.secretKey}")
    static String secretKey;

    @Value("${JWT.ttlMillis}")
    static int expireMillis;

    /**
     * token生成
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expireMillis);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
           builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(secretKey));
        return token;
    }

    /**
     * 检验token
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        return verify;
    }
}
