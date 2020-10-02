package com.example.advance.methodreference.arraydemo;

public class ArrayDemo {
    public static void main(String[] args) {
        initArray(10, new ArrayBuilder() {
            @Override
            public int[] builder(int length) {
                return new int[length];
            }
        });

        // Lambda
        initArray(10, length -> new int[length]);

        // 数组的构造器引用
        initArray(10, int[]::new);
    }

    private static int[] initArray(int length, ArrayBuilder arrayBuilder) {
        return arrayBuilder.builder(length);
    }
}
