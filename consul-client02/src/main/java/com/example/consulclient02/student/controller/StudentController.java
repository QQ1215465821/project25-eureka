package com.example.consulclient02.student.controller;

import com.example.consulclient02.student.service.StudentServiceFeign;
import org.example.student.Student;
import org.example.student.StudentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class StudentController {

    @Autowired
    private StudentServiceFeign studentServiceFeign;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable String id){
        System.out.println("消费者," + port + ", "+Thread.currentThread().getName() + "," + Thread.currentThread().getId()  + "," + Thread.currentThread().getThreadGroup());
        return studentServiceFeign.getStudent(id);
    }
    /*
    host01,8081, http-nio-8081-exec-5,57,java.lang.ThreadGroup[name=main,maxpri=10]
     */
}
