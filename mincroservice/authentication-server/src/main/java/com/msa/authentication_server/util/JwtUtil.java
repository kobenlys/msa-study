package com.msa.authentication_server.util;

import com.msa.authentication_server.dto.AccountDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {
    public static String generateToken(AccountDto accountDto) {
        Date now = new Date();
        byte[] keyBytes = Base64.getDecoder().decode("ssafy");
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .subject(accountDto.getAccountId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000000))
                .signWith(key)
                .compact();
    }
}
