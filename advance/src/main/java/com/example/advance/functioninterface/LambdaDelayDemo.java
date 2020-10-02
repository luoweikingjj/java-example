package com.example.advance.functioninterface;


public class LambdaDelayDemo {
    public static void main(String[] args) {
        String string1 = "a";
        String string2 = "b";
        String string3 = "c";

        log(1, string1 + string2 + string3);
        log(2, string1 + string2 + string3);// 字符串拼接的代码一定会执行，但是却不一定会被输出

        System.out.println("-------------------------");

        log1(1, () -> string1 + string2 + string3);
        log1(2, () -> {
            System.out.println("Lambda执行！");
            return string1 + string2 + string3;
        });// 【Lambda执行！】不会输出，说明字符串拼接的代码没有执行

        // 通过lambda语法，将代码延迟执行，从而达到节省性能的效果
    }

    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    private static void log1(int level, MessageBuilder messageBuilder) {
        if (level == 1) {
            System.out.println(messageBuilder.buildMessage());
        }
    }
}
