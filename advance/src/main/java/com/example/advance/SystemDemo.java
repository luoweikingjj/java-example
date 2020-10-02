package com.example.advance;

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        timing();
        arrayCopyDemo();
    }

    private static void timing() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时毫秒：" + (endTime - startTime));
    }

    private static void arrayCopyDemo() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        System.arraycopy(arr1, 1, arr2, 1, 2);

        System.out.println(Arrays.toString(arr1));//[1, 2, 3]
        System.out.println(Arrays.toString(arr2));//[4, 2, 3]
    }
}
