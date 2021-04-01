package com.example.eurekaclient02.student.service;

import org.example.student.StudentApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-15 14:50
 */
//@FeignClient(value = "eureka-client01", contextId = "RemoteStudentService", url = "http://host06:9999")
@FeignClient(value = "eureka-client01", contextId = "RemoteStudentService", fallback = StudentServiceFeignFallback.class)
public interface RemoteStudentService extends StudentApi {
}
