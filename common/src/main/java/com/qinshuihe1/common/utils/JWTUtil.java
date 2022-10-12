package com.qinshuihe1.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JWTUtil {
    private  static  final  long JWT_TTL = 60 * 60 * 1000;

    private  static  final  String  JWT_SIGN = "menglingjie";

    public  static  String createJWT(String subject){
        SignatureAlgorithm signatureAlgorithm =  SignatureAlgorithm.HS256;

        //当前时间
        long nowMillis = System.currentTimeMillis();
        Date nowDate = new Date(nowMillis);

        //过期时间
        long expMills =  nowMillis+JWT_TTL;
        Date expDate = new Date(expMills);

        String uuid = UUID.randomUUID().toString().replace("-","");
        JwtBuilder jwtBuilder  = Jwts.builder().setHeaderParam("type","JWT")
                //设置唯一标识
                .setId(uuid)
                //设置当前时间
                .setIssuedAt(nowDate)
                //设置主题内容
                .setSubject(subject)
                //设置过期时间
                .setExpiration(expDate)
                //设置系统签名
                .setAudience(JWT_SIGN)
                //设置不能提前的开始时间点
                .setNotBefore(nowDate)
                //设置加密key
                .signWith(signatureAlgorithm,getSecretKey());
        return   jwtBuilder.compact();

    }

    /**
     * 对token进行解析
     * @param token
     * @return
     */
    public  static Claims parseJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 获取加密key
     * @return
     */
    private  static SecretKey getSecretKey(){
        byte[] encodeKey = Base64.getDecoder().decode(JWT_SIGN);
        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        return  key;
    }
}
