package com.kinnong.web.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jwt工具类
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String secret;
    private long expire;
    private String header;

    /**
     * 生成jwt token
     */
    public String generateToken(Long userId) throws Exception {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return JWT.create().withAudience(String.valueOf(userId)).withExpiresAt(expireDate).sign(Algorithm.HMAC384(secret));
    }

    public DecodedJWT getDecodedByToken(String token) {
        try {
            return JWT.decode(token);
        } catch (Exception e) {
//            logger.debug("validate is token error ", e);
            return null;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        DecodedJWT decode = JWT.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJhdWQiOiIxIiwiZXhwIjoxNzA1Nzg3ODc3fQ.hSgqTIIHxT71BwlM_4jjpS9_qrpX-9YfmO14ejrEUp_43AvO2jxKfMBC2RvqFLru");
//        String claims = decode.getSubject();


        //检测签名私钥
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC384("b65vhvpob8kw5qnuh09rihdjscja4ecw")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJhdWQiOiIxIiwiZXhwIjoxNzA1OTM1MzE3fQ.E9vkW_OcYvZ21boOWtnQeZqUeubqyPTmI3pFc4mjH-_c-Zh19SyvlyYWWOS66qeh");

        System.out.println("过期时间: " + decodedJWT.getExpiresAt());

        long time = decodedJWT.getExpiresAt().getTime();

        System.out.println(time > new Date().getTime());

    }


    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(String token) throws UnsupportedEncodingException {

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC384(secret)).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

//        System.out.println("过期时间: " + decodedJWT.getExpiresAt());

//        System.out.println(decodedJWT.getExpiresAt().getTime() > new Date().getTime());
        return decodedJWT.getExpiresAt().getTime() < new Date().getTime();


    }
/*
    public boolean isTokenExpired(Date expiration,String token) throws UnsupportedEncodingException {
//        return expiration.before(new Date()) || expiration.after(new Date(1696089601000l));


        //检测签名私钥
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC384(secret)).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        System.out.println(decodedJWT.getClaim("username").asString());

        System.out.println("过期时间: "+decodedJWT.getExpiresAt());

        return new Date().before(decodedJWT.getExpiresAt());

//        return expiration.before(new Date()) || expiration.after(new Date());

    }
*/

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


}
