package com.example.eurekaclient02.teacher.entity;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:26
 */
public class Teacher {
    private String name;
    private Integer age;

    public Teacher() {
    }

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
