package com.example.advance;

/**
 * 1. 定义实现类时，确定泛型的类型
 */
public class MyGenericClass1 implements MyGenericInterface<String> {
    public String str;

    @Override
    public void add(String s) {
        this.str = s;
    }

    @Override
    public void unset() {
        this.str = null;
    }
}
