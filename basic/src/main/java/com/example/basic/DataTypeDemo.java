package com.example.basic;

/**
 * 数据类型转换demo
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        auto();
        force();
    }

    private static void auto() {
        byte a = 1;
        byte a1 = 1;
        short b = 1;
        char c = '1';
        int d = 1;
        long e = 1L;
        float f = 1.1F;
        double g = 1.1;

        //byte、short、char‐‐>int‐‐>long‐‐>float‐‐>double
        int t1 = a + b;
        int t2 = a + c;
        int t3 = a + d;
        long t4 = a + e;
        float t5 = a + f;
        double t6 = a + g;

        byte a2 = 1 + 1;//编译通过
        // byte a2 = a + a1;//编译报错，因为编译器无法直接确定变量的值
    }

    private static void force() {
        int a = (int) 1.1;
        System.out.println(a);

        short b = 1;
        short c = (short)(b + 1);
        System.out.println(c);
    }
}
