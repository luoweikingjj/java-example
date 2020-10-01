package com.example.basic.sub;

import com.example.basic.AuthorityClass;

public class AuthorityClassSub {
    /**
     * 5、不同包，不是子类
     */
    public void method(){
        AuthorityClass authorityClass = new AuthorityClass();

        System.out.println(authorityClass.number1);
        // System.out.println(authorityClass.number2); //不能访问。不同包，不是子类
        // System.out.println(authorityClass.number3); //不能访问。不同包，不是子类
        // System.out.println(authorityClass.number4); //不能访问。不同包，不是子类
    }
}
