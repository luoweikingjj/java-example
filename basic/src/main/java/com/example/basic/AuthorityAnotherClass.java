package com.example.basic;

/**
 * 2、同一个包，不同类
 */
public class AuthorityAnotherClass {
    public void method(){
        AuthorityClass authorityClass = new AuthorityClass();

        System.out.println(authorityClass.number1);
        System.out.println(authorityClass.number2);
        System.out.println(authorityClass.number3);
        // System.out.println(authorityClass.number4); // 不能访问。同一个包，不同类
    }
}
