package com.example.consulclient02.student.service;

import org.example.student.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceFeignFallback implements StudentServiceFeign{
    @Override
    public String getStudent(String id) {
        return "getStudent("+id+")失败了";
    }

    @Override
    public Student addStudent(Student student) {
        Student student1 = new Student();
        student1.setName("addStudent("+student+")失败了");
        return student1;
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = new Student();
        student1.setName("updateStudent("+student+")失败了");
        return student1;
    }

    @Override
    public String deleteStudent(String id) {
        return "deleteStudent("+id+")失败了";
    }
}
