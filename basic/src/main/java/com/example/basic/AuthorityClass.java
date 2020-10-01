package com.example.basic;

/**
 * 1、同一个包，同一个类
 */
public class AuthorityClass {
    public int number1 = 10;
    protected int number2 = 10;
    int number3 = 10;
    private int number4 = 10;

    public void method() {
        System.out.println(this.number1);
        System.out.println(this.number2);
        System.out.println(this.number3);
        System.out.println(this.number4);
    }
}
