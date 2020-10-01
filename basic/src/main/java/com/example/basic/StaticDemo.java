package com.example.basic;

public class StaticDemo {
    public static void main(String[] args) {
        // test();
        callDemo();
    }

    private static void test(){
        Student student1 = new Student("小黑", 20);
        Student student2 = new Student("小白", 21);
        Student student3 = new Student("小红", 22);

        student1.show();
        student2.show();
        student3.show();
    }

    private static void callDemo(){
        System.out.println(Student.numberOfStudent);
        Student student = new Student("小黑", 20);

        Student.showNum();

        System.out.println(Student.numberOfStudent);
    }
}
