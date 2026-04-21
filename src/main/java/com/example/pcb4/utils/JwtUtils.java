package com.example.pcb4.utils;

import com.example.pcb4.entity.SysUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class JwtUtils {
    private static final String SECRET_KEY = "my-test-key-at-least-256-bits-long";
    private static final Long EXPIRATION_TIME = (long) 86400000;
    public static final String TOKEN_HEADER = "Authorization";
    private static final String LOGIN_TOKEN_KEY = "login_token_key:";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    //生成token
    public static String generateToken(Map<String, Object> claims, String subject) {
        String uuid = UUID.randomUUID().toString();
        return Jwts.builder()
                .claims(claims)
                .claim(LOGIN_TOKEN_KEY,uuid)
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    public String getToken(HttpServletRequest request) {
        //获取未解码的token
        String encoderToken = request.getHeader(TOKEN_HEADER);
        // 判断是否为null
        if (encoderToken!=null && !encoderToken.isEmpty()) {
            // 解码
            String tokenBearer = URLDecoder.decode(encoderToken, StandardCharsets.UTF_8);
            if (tokenBearer != null && tokenBearer.startsWith(TOKEN_PREFIX)) {
                //  拆分token
                return tokenBearer.replace(TOKEN_PREFIX, "");
            }
        }
        return null;
    }

    //解析token
    public static Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token已过期");
        } catch (MalformedJwtException e) {
            throw new RuntimeException("Token格式错误");
        } catch (Exception e) {
            throw new RuntimeException("Token解析失败"+e.getMessage());
        }
    }

    //验证token是否有效
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
