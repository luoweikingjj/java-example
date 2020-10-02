package com.example.advance;

public class StringBuilderDemo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);// 空白

        StringBuilder stringBuilder1 = new StringBuilder("test");
        System.out.println(stringBuilder1);// test

        stringBuilder1.append("--app");
        System.out.println(stringBuilder1);// test--app

        stringBuilder1.append("--aa1").append("--aa2--").append(100).append("--|--").append(true);
        System.out.println(stringBuilder1);// test--app--aa1--aa2--100--|--true
    }
}
