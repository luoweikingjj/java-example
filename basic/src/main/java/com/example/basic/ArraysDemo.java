package com.example.basic;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        int[] arr = {2, 34, 35, 4, 657, 8, 69, 9};
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        String line = "ysKUreaytWTRHsgFdSAoidq";
        char[] chars = line.toCharArray();

        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
    }
}
