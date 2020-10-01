package com.example.basic;

public class StringDemo {

    public static void main(String[] args) {
        // test();
        operator();
    }

    private static void test() {
        String s1 = "abc";
        s1 = "eee"; // s1的指向变化了

        s1 = "abc";

        String s2 = "abc"; // s2的指向和s1一致
        System.out.println(s2.equals(s1)); //true

        char[] data = {'a', 'b', 'c'};
        String s3 = new String(data); // 等同于 s1 和 s2
        System.out.println(s3.equals(s2)); //true

        byte[] bytes = {97, 98, 99}; // 根据 ASCII 码转换为 a、b、c
        String s4 = new String(bytes); // 等同于 s1、 s2 和 s3
        System.out.println(s4.equals(s2)); //true

        String s5 = "ABC";
        System.out.println(s5.equals(s2));//false
        System.out.println(s5.equalsIgnoreCase(s2));//true
    }

    private static void operator() {
        String s1 = "abc";

        System.out.println(s1.length());//3
        System.out.println(s1.concat("-def"));//abc-def
        System.out.println(s1.charAt(1));//b
        System.out.println(s1.indexOf("c"));//2
        System.out.println(s1.substring(1));//bc
        System.out.println(s1.substring(1, 2));//b  不包含结尾

        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);//a,b,c
        }

        byte[] bytes = s1.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]); // 97,98,99
        }

        System.out.println(s1.replace('a', 'A'));// Abc

        String s2 = "aa,bb,cc";
        String[] s3 = s2.split(","); // ["aa","bb","cc"]
        System.out.println(s3.length);
        for (int i = 0; i < s3.length; i++) {
            System.out.println(s3[i]);// aa bb cc
        }
    }
}
