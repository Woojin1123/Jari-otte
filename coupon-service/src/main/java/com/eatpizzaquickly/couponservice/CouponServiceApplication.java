package com.eatpizzaquickly.couponservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableCaching // 캐시 기능 활성화
@EnableJpaAuditing
@ComponentScan(basePackages = {
        "com.eatpizzaquickly.couponservice",
        "com.eatpizzaquickly.datasourcecommon"
})
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);
    }

}
