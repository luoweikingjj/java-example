package com.example.basic;

public class InterfaceDemo {
    public static void main(String[] args) {
        InstanceName instanceName = new InstanceName();

        instanceName.method();

        instanceName.defaultMethod1();
        instanceName.defaultMethod2();

        InterfaceName.staticMethod1();
        InterfaceName.staticMethod2();
    }
}

interface InterfaceName {
    public abstract void method();

    public default void defaultMethod1() {
        System.out.println("defaultMethod1()");
        System.out.println("Common Code ...");
//        privateCommonMethod();
    }

    public default void defaultMethod2() {
        System.out.println("defaultMethod2()");
        System.out.println("Common Code ...");
//        privateCommonMethod();
    }

    public static void staticMethod1() {
        System.out.println("staticMethod()");
        privateStaticCommonMethod();
    }

    public static void staticMethod2() {
        System.out.println("staticMethod()");
        privateStaticCommonMethod();
    }

//    /**
//     * java9 开始才有效
//     */
//    void privateCommonMethod() {
//        System.out.println("privateCommonMethod()");
//    }

    /**
     * java9 开始才有效
     */
    static void privateStaticCommonMethod() {
        System.out.println("privateStaticCommonMethod()");
    }

}

class InstanceName implements InterfaceName {

    @Override
    public void method() {// 必须实现抽象方法
        System.out.println("实现抽象方法");
    }
}