package com.example.advance;

public class ObjectDemo {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        System.out.println(person1.toString());
        System.out.println(person1.equals(person2));
    }
}
