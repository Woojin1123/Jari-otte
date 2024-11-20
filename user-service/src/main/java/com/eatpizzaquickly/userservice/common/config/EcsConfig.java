package com.eatpizzaquickly.userservice.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@Slf4j
public class EcsConfig {
    @Value("${server.port}")
    String port;
    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {

        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            log.info("ECS Task Container Private Ip address is {}", ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        config.setIpAddress(ip);
        config.setPreferIpAddress(true);
        config.setNonSecurePortEnabled(true);
        config.setNonSecurePort(Integer.parseInt(port));
        return config;
    }
}
