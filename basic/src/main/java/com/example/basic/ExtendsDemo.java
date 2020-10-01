package com.example.basic;

public class ExtendsDemo {
    public static void main(String[] args) {
        // 创建子类对象
        Zi z = new Zi();// Fu() Zi()

        // 调用子类中的show方法
        z.show();

        z.method01();//Zi类中的method01方法执行
        z.superMethod01();//Fu类中的method01方法执行

        z.method02();//Fu类中的method02方法执行
    }
}

class Fu {
    // Fu中的成员变量。
    int num = 5;
    int num2 = 6;

    public void method01(){
        System.out.println("Fu类中的method01方法执行");
    }

    public void method02(){
        System.out.println("Fu类中的method02方法执行");
    }

    Fu() {
        System.out.println("Fu()");
    }
}

class Zi extends Fu {
    // Zi中的成员变量
    int num = 6;

    // Zi中的成员方法
    public void show() {
        // 访问父类中的num
        System.out.println("Fu num=" + super.num);
        // 访问父类中的num2
        System.out.println("Fu num2=" + num2); // 继承而来，没有重名，所以直接访问。
        // 访问子类中的num
        System.out.println("Zi num=" + this.num);
    }

    @Override
    public void method01(){
        System.out.println("Zi类中的method01方法执行");
    }

    public void superMethod01(){
        super.method01();
    }

    Zi() {
        // super(); // 手动调用父类构造方法，不手动调用，系统也会自动调用，调用super() 方法必须是在第一行，而且只能有一个。
        System.out.println("Zi()");
    }
}

