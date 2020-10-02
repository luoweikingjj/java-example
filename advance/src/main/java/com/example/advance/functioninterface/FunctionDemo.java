package com.example.advance.functioninterface;


import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        // FunctionDemo1();
        // FunctionDemo2();
        FunctionDemo3();
    }

    /**
     * 1. 将字符串截取数字年龄部分，得到字符串；
     * 2. 将上一步的字符串转换成为int类型的数字；
     * 3. 将上一步的int数字累加100，得到结果int数字。
     */
    private static void FunctionDemo3() {
        String string = "赵丽颖,20";
        //String age = string.split(",")[1]; //不能直接获取到整数的
        // int age = getAgeNum(string, new Function<String, String>() {
        //     @Override
        //     public String apply(String s) {
        //         return s.split(",")[1];
        //     }
        // }, new Function<String, Integer>() {
        //     @Override
        //     public Integer apply(String s) {
        //         return Integer.parseInt(s);
        //     }
        // }, new Function<Integer, Integer>() {
        //     @Override
        //     public Integer apply(Integer integer) {
        //         return integer + 100;
        //     }
        // });

        int age = getAgeNum(
                string, s -> s.split(",")[1],
                s -> Integer.parseInt(s),
                integer -> integer += 100
        );
        System.out.println(age);

    }

    private static int getAgeNum(String string, Function<String, String> function1, Function<String, Integer> function2, Function<Integer, Integer> function3) {
        return function1.andThen(function2).andThen(function3).apply(string);
    }

    private static void FunctionDemo2() {
        // method2(new Function<String, Integer>() {
        //     @Override
        //     public Integer apply(String s) {
        //         return Integer.parseInt(s);
        //     }
        // }, new Function<Integer, String>() {
        //     @Override
        //     public String apply(Integer integer) {
        //         return String.valueOf(integer);
        //     }
        // });

        method2(
                s -> Integer.parseInt(s),
                integer -> String.valueOf(integer)
        );//10
    }

    private static void method2(Function<String, Integer> function1, Function<Integer, String> function2) {
        String string = function1.andThen(function2).apply("10");
        System.out.println(string);
    }

    /**
     * 根据类型T的参数获取类型R的结果。使用的场景例如：将 String 类型转换为 Integer 类型。
     */
    private static void FunctionDemo1() {
        // method1(new Function<String, Integer>() {
        //     @Override
        //     public Integer apply(String s) {
        //         return Integer.parseInt(s);
        //     }
        // });

        method1(s -> Integer.parseInt(s));
    }

    private static void method1(Function<String, Integer> function) {
        int num = function.apply("10");
        System.out.println(num + 20);
    }
}
