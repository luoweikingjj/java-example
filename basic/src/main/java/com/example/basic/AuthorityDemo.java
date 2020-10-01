package com.example.basic;

import com.example.basic.sub.AuthorityClassExtendSub;
import com.example.basic.sub.AuthorityClassSub;

public class AuthorityDemo {
    public static void main(String[] args) {
        // 1、同一个包，同一个类
        AuthorityClass authorityClass = new AuthorityClass();
        authorityClass.method();

        // 2、同一个包，不同类
        AuthorityAnotherClass authorityAnotherClass = new AuthorityAnotherClass();
        authorityAnotherClass.method();

        // 3、同一个包，子类
        AuthorityClassExtends authorityClassExtends = new AuthorityClassExtends();
        authorityClassExtends.method();

        // 4、不同包，子类
        AuthorityClassExtendSub authorityClassExtendSub = new AuthorityClassExtendSub();
        authorityClassExtendSub.method();

        // 5、不同包，不是子类
        AuthorityClassSub authorityClassSub = new AuthorityClassSub();
        authorityClassSub.method();
    }
}
