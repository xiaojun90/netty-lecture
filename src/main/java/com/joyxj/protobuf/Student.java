package com.joyxj.protobuf;

import java.io.Serializable;

/**
 * @author: xiaojun
 * @version: 2018/11/30
 */
public class Student implements Serializable {

    private String name;

    private int age;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
