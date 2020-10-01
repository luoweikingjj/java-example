package com.example.basic;

public class FinalDemo {
    public static void main(String[] args) {
        // 声明变量，使用final修饰
        final int a = 1;

        // a = 2; //报错，不可重新赋值

        final Student student = new Student();

        // student = new Student(); // 报错，指向了新的对象，地址值改变。

        student.setName("小黑");

    }
}

// final修饰的类，不能被继承
final class FinalClass {
    public final void finalMethod() {
        System.out.println("final修饰的方法，不能被重写");
    }
}