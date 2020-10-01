package com.example.basic;

public class InnerClassDemo {
    public static void main(String[] args) {
        demo();
        anonymousDemo1();
        anonymousDemo2();
    }

    /**
     * 内部类
     */
    private static void demo() {
        // 创建外部类对象
        Person p = new Person();
        // 创建内部类对象
        Person.Heart heart = p.new Heart();
        // 调用内部类方法
        heart.jump();
        // 调用外部类方法
        p.setLive(false);
        // 调用内部类方法
        heart.jump();
    }

    /**
     * 匿名内部类1
     */
    private static void anonymousDemo1() {
        /**
         * 1.等号右边:是匿名内部类，定义并创建该接口的子类对象
         * 2.等号左边:是多态赋值,接口类型引用指向子类对象
         */
        FlyAble f = new FlyAble() {
            public void fly() {
                System.out.println("我飞了~~~");
            }
        };
        // 调用 fly方法,执行重写后的方法
        f.fly();
    }

    /**
     * 匿名内部类2
     */
    private static void anonymousDemo2() {
        /**
         * 1.等号右边:是匿名内部类，定义并创建该接口的子类对象
         * 2.等号左边:是多态赋值,接口类型引用指向子类对象
         */
        FlyAble f = new FlyAble() {
            public void fly() {
                System.out.println("我飞了~~~");
            }
        };
        // 将f传递给showFly方法中
        showFly(f);
    }

    private static void showFly(FlyAble f) {
        f.fly();
    }
}
