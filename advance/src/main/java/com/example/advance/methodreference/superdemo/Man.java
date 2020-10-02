package com.example.advance.methodreference.superdemo;

public class Man extends Human {
    public static void main(String[] args) {
        new Man().show();
    }

    @Override
    public void sayHello() {
        System.out.println("大家好,我是Man!");
    }

    // 定义方法method,参数传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        // 调用method方法,使用Lambda表达式
        method(new Greetable() {
            @Override
            public void greet() {
                new Human().sayHello();
            }
        });

        // 简化Lambda
        method(() -> new Human().sayHello());

        // 使用super关键字代替父类对象
        method(() -> super.sayHello());

        // 方法引用
        // 4. 通过super引用成员方法
        method(super::sayHello);

        // 5. 通过this引用成员方法
        method(this::sayHello);
    }
}
