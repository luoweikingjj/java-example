package com.example.basic;

/**
 * 运算符demo
 */
public class OperatorDemo {
    public static void main(String[] args) {
        arithmetic();
        selfOperator();
        assignment();
        compare();
        logic();
        ternaryOperator();
    }

    /**
     * 算术运算符
     */
    private static void arithmetic() {
        System.out.println(2 + 1);//3
        System.out.println(2 - 1);//1
        System.out.println(2 * 1);//2
        System.out.println(2 / 1);//2
        System.out.println(2 % 1);//0
    }

    /**
     * 自操作符
     */
    private static void selfOperator() {
        int a = 1;
        int b = a++;
        System.out.println(a);//2
        System.out.println(b);//1

        int c = 1;
        int d = ++c;
        System.out.println(c);//2
        System.out.println(d);//2
    }

    /**
     * 赋值运算符
     */
    private static void assignment() {
        int a = 1;
        a += 1;
        System.out.println(a);//2

        // 注意点
        short b = 1;
        b += 1;// 正确
        // b = b +1; //编译错误，因为数据类型转换为int，而原有b的类型还是short
        System.out.println(b);
    }

    /**
     * 比较运算符
     */
    private static void compare() {
        System.out.println(1 == 1);//true
        System.out.println(1 < 2);//true
        System.out.println(1 > 2);//false
        System.out.println(1 <= 2);//true
        System.out.println(1 >= 2);//false
        System.out.println(1 != 2);//true
    }

    /**
     * 逻辑运算符
     */
    private static void logic() {
        System.out.println(true && true);//true
        System.out.println(true && false);//false
        System.out.println(false && true);//false，右边不计算
        System.out.println(false || false);//false
        System.out.println(false || true);//true
        System.out.println(true || false);//true，右边不计算
        System.out.println(!false);//true
    }

    /**
     * 三元运算符
     */
    private static void ternaryOperator() {
        int i = (1 == 2 ? 100 : 200);
        System.out.println(i);//200
        int j = (3 <= 4 ? 500 : 600);
        System.out.println(j);//500
    }
}
