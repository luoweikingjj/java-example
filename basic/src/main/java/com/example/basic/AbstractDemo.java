package com.example.basic;

public class AbstractDemo {
    public static void main(String[] args) {
        InstanceClass instanceClass = new InstanceClass();
        instanceClass.AbstractMethod();
    }
}

abstract class AbstractClass {
    public AbstractClass(){
        System.out.println("抽象类构造方法 AbstractClass()");
    }

    public abstract void AbstractMethod(); //有抽象方法存在，所在类必须声明为抽象类
}

class InstanceClass extends AbstractClass {
    public InstanceClass() {
        System.out.println("实现类构造方法 InstanceClass()");
    }

    @Override
    public void AbstractMethod() {
        // 必须实现抽象方法
        System.out.println("实现抽象方法");
    }
}