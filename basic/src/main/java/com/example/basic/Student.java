package com.example.basic;

public class Student {
    // 成员变量
    private String name;
    private int age;
    // 学生的id
    private int sid;
    // 类变量，记录学生数量，分配学号
    public static int numberOfStudent = 0;

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

    public void show(){
        System.out.println("Student : name=" + name + ", age=" + age + ", sid=" + sid);
    }

    public static void showNum() {
        System.out.println("num:" + numberOfStudent);
    }
}
