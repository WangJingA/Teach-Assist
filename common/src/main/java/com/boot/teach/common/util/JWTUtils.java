package com.boot.teach.common.util;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;


/**
 * jwt工具类
 * @author : hzx
 * @date : 2023/5/15
 */
public class JWTUtils {

    static String secretKey = "$QWERTYUIOP!AAZXCVBNMDGJJKKLNNV<?";


    static int expireMillis = 360000;



    public static String getToken(Long id,String username) {
        return Jwts.builder()
                .setId(id.toString())
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+expireMillis))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }
    public static String getToken(String id,String username) {
        return Jwts.builder()
                .setId(id)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+expireMillis))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public static Claims parserToken(String token) throws ExpiredJwtException {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
