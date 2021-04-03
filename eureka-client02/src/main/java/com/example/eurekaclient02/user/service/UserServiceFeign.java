package com.example.eurekaclient02.user.service;

import org.example.user.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client01")
public interface UserServiceFeign extends UserApi {
}
