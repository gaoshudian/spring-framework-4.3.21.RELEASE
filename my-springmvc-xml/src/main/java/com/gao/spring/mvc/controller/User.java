package com.gao.spring.mvc.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class User implements Serializer {

    private String name;
    private String age;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime myDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDateTime getMyDate() {
        return myDate;
    }

    public void setMyDate(LocalDateTime myDate) {
        this.myDate = myDate;
    }

    public User(){

    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String age, LocalDateTime myDate) {
        this.name = name;
        this.age = age;
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", myDate=" + myDate +
                '}';
    }

    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
