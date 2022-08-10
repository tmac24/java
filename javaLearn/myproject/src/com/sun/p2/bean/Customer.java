package com.sun.p2.bean;

/**
 * @program: basic-code
 * @description: Customer为实体对象，用来封装客户信息
 * @author: tmac24
 * @create: 2021-01-18 18:20
 */
public class Customer {
    private String name; //客户姓名
    private char gender;
    private int age;
    private String phone;
    private String email;

    // 快捷键

    /**
     * Ctrl+Shift+/：使用注释
     * Ctrl+Alt+L：格式化代码
     *
     * @return
     */
    // 输入/** ,点击“Enter”，自动根据参数和返回值生成注释模板
    // Alt + Enter 一个生成，选择getter + setter 方法
    // Alt + Ins 一次生成
    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 构造器constructor
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

}
