package com.example.advance.functioninterface;

/**
 * 接口中有且仅有一个抽象方法
 */
@FunctionalInterface
public interface MyFunctionInterface {
    // 接口当中抽象方法的 public abstract是可以省略的
    void myMethod();
}
