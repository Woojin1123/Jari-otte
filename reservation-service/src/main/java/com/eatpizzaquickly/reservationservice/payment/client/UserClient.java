package com.eatpizzaquickly.reservationservice.payment.client;

import com.eatpizzaquickly.reservationservice.common.config.FeignConfig;
import com.eatpizzaquickly.reservationservice.payment.dto.response.UserResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", configuration = FeignConfig.class)
public interface UserClient {

    String CIRCUIT_BREAKER_NAME = "userService";

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "getUserByIdFallback")
    @GetMapping("/api/v1/users/{userId}")
    ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable("userId") Long userId);

    // Fallback method
    default ApiResponse<UserResponseDto> getUserByIdFallback(Long userId, Exception ex) {
        // 사용자 정보 조회 실패 시
        return ApiResponse.success("Failed to fetch user information", null);
    }
}