package com.example.basic;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));//1
        System.out.println(Math.ceil(1.32));//2.0
        System.out.println(Math.floor(1.32));//1.0
        System.out.println(Math.ceil(-1.32));//-1.0
        System.out.println(Math.floor(-1.32));//-2.0
        System.out.println(Math.round(1.32));//1

        test();
    }

    private static void test(){
        // 定义最小值
        double min = -10.8;
        // 定义最大值
        double max = 5.9;

        // 定义变量计数
        int count = 0;
        // 范围内循环
        for (double i = Math.ceil(min); i <= max; i++) {
            // 获取绝对值并判断
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1) {
                // 计数
                count++;
            }
        }

        System.out.println("个数为: " + count + " 个");
    }
}
