package com.eatpizzaquickly.reservationservice.payment.client;

import com.eatpizzaquickly.reservationservice.common.config.FeignConfig;
import com.eatpizzaquickly.reservationservice.payment.dto.response.UserResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {


    @GetMapping(value = "/api/v1/users/{userId}",produces = "application/json")
    ApiResponse<UserResponseDto> getUserById(@PathVariable("userId") Long userId);


}