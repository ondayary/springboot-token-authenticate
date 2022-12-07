package com.example.token.service;

import com.example.token.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Value("${jwt.token.secret}")
    private String secretKey;

    private Long expiredTimeMs = 1000 * 60 * 60l;

    public String login(String userName, String password) {
        log.info("secretKey:{}", secretKey);
        return JwtUtil.createToken("daon", secretKey, expiredTimeMs);
    }
}
