package com.example.eurekaclient02.student.controller;

import com.example.eurekaclient02.student.service.RemoteStudentService;
import org.example.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-15 14:46
 */
@RestController
public class StudentController {

    @Value("${eureka.instance.hostname}")
    private String hostName;
    @Value("${server.port}")
    private Integer port;
    @Autowired
    private RemoteStudentService remoteStudentService;

    @GetMapping("/addStudent")
    public Object addStudent(){
        Student student = new Student("aaa", 20);
        Student student1 = remoteStudentService.addStudent(student);
        System.out.println("student1 = " + student1);
        return student1;
    }

    @GetMapping("/getStudent")
    public Object getStudent(){
        String str = remoteStudentService.getStudent("1");
        System.out.println(hostName + "," + port + ", "+Thread.currentThread().getName() + "," + Thread.currentThread().getId()  + "," + Thread.currentThread().getThreadGroup());
        return str;
    }
}
