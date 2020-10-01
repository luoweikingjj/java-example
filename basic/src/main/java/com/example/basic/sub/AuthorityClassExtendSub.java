package com.example.basic.sub;

import com.example.basic.AuthorityClass;

public class AuthorityClassExtendSub extends AuthorityClass {
    /**
     * 4、不同包，子类
     */
    public void method(){
        AuthorityClass authorityClass = new AuthorityClass();

        System.out.println(authorityClass.number1);
        // System.out.println(authorityClass.number2); //不能访问。不同包，子类
        // System.out.println(authorityClass.number3); //不能访问。不同包，子类
        // System.out.println(authorityClass.number4); //不能访问。不同包，子类

        System.out.println(super.number1);
        System.out.println(super.number2);
        // System.out.println(authorityClass.number3); //不能访问。不同包，子类
        // System.out.println(authorityClass.number4); //不能访问。不同包，子类
    }
}
