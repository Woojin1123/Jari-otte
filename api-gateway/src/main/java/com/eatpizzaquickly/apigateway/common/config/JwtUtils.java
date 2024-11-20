package com.eatpizzaquickly.apigateway.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class JwtUtils {

    private final SecretKey key;

    public JwtUtils(@Value("${jwt.secret.key}") String secret) {
        // 초기화 블록에서 한 번만 할당하도록 수정
        SecretKey initializedKey;
        try {
            // 1. Base64 디코딩
            byte[] decodedKey = Base64.getDecoder().decode(secret);

            // 2. 키 길이 검증 및 로깅
            log.info("Decoded key length: {} bits", decodedKey.length * 8);

            // 3. 안전한 키 생성
            if (decodedKey.length < 32) { // 256 bits 미만일 경우
                log.warn("Provided key is too short. Generating a secure key...");
                initializedKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            } else {
                initializedKey = Keys.hmacShaKeyFor(decodedKey);
            }

            log.info("JWT Key initialized successfully");
        } catch (IllegalArgumentException e) {
            log.error("Failed to decode JWT secret key", e);
            // 키 디코딩 실패 시 안전한 새 키 생성
            initializedKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            log.info("Generated new secure JWT key");
        }

        // final 변수에 한 번만 할당
        this.key = initializedKey;
    }

    public String substringToken(String tokenHeader) {
        if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
            log.debug("Invalid token header format");
            return null;
        }
        return tokenHeader.substring(7);
    }

    public Claims extractClaims(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            log.debug("Token claims extracted successfully");
            return claims;
        } catch (Exception e) {
            log.error("Failed to extract claims from token: {}", e.getMessage());
            return null;
        }
    }

    // 키 유효성 검사 메서드
    private boolean isValidKeyLength(byte[] key) {
        return key.length >= 32; // 최소 256 비트
    }
}