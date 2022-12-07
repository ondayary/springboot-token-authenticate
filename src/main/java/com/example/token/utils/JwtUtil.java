package com.example.token.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Date;

@RequiredArgsConstructor
public class JwtUtil {

    public static boolean isExpired(String token, String secretKey) {
        // expired가 지금보다 전에 됐으면 true
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public static String createToken(String userName, String key, Long expiredUntilMs) {
        Claims claims = Jwts.claims();
        claims.put("userName", userName);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredUntilMs))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
