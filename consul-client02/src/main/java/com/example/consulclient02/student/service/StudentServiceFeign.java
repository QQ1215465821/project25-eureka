package com.example.consulclient02.student.service;

import org.example.student.StudentApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "consul-client01")
public interface StudentServiceFeign extends StudentApi {
}
