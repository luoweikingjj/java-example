package com.example.basic;

public class ObjectDemo {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("小黑");
        student.setAge(20);

        System.out.println(student.getName());
        System.out.println(student.getAge());

        student.eat();
    }
}