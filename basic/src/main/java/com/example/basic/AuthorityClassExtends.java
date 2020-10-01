package com.example.basic;

public class AuthorityClassExtends extends com.example.basic.AuthorityClass {
    /**
     * 3、同一个包，子类
     */
    public void method(){
        AuthorityClass authorityClass = new AuthorityClass();

        System.out.println(authorityClass.number1);
        System.out.println(authorityClass.number2);
        System.out.println(authorityClass.number3);
        // System.out.println(authorityClass.number4); //不能访问。同一个包，子类

        System.out.println(super.number1);
        System.out.println(super.number2);
        System.out.println(super.number3);
        // System.out.println(super.number4); //不能访问。同一个包，子类
    }
}
