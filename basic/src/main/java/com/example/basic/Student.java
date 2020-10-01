package com.example.basic;

public class Student {
    // 成员变量
    private String name;
    private int age;

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

    /**
     * 无参数构造方法
     */
    public Student(){

    }

    /**
     * 有参数构造方法
     */
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat() {
        //局部变量
        String food = "苹果";
        System.out.println("吃" + food);
    }
}
