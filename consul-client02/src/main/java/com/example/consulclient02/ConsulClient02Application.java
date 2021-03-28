package com.example.consulclient02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsulClient02Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClient02Application.class, args);
    }

}
