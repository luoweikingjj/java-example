package com.example.advance.functioninterface;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        // doSomething(new MyFunctionInterface() {
        //     @Override
        //     public void myMethod() {
        //         System.out.println("Lambda执行啦！");
        //     }
        // });

        doSomething(() -> System.out.println("Lambda执行啦！"));
    }

    private static void doSomething(MyFunctionInterface myFunctionInterface) {
        myFunctionInterface.myMethod();
    }
}
