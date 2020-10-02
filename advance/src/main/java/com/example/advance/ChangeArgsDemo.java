package com.example.advance;

public class ChangeArgsDemo {
    public static void main(String[] args) {
        int[] arr = {1, 4, 62, 431, 2};
        int sum = getSum1(arr);
        System.out.println(sum);
        // 6  7  2 12 2121
        // 求 这几个元素和 6  7  2 12 2121
        int sum2 = getSum2(6, 7, 2, 12, 2121);
        System.out.println(sum2);
    }

    /**
     * 完成数组  所有元素的求和 原始写法
     */
    public static int getSum1(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        return sum;
    }

    //可变参数写法
    public static int getSum2(int... arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }
}
