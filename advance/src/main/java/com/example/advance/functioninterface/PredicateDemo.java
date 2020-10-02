package com.example.advance.functioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // predicateInterfaceDemo();
        // predicateInterfaceDemo1();
        predicateInterfaceDemo2();
    }

    /**
     * 筛选
     * 1. 必须为女生
     * 2. 姓名为4个字
     */
    private static void predicateInterfaceDemo2() {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        List<String> list = filterMethod(array,
                s -> "女".equals(s.split(",")[1]),
                s -> s.split(",")[0].length() == 4
        );
        System.out.println(list);//[迪丽热巴,女, 古力娜扎,女]
    }

    private static List<String> filterMethod(String[] array, Predicate<String> predicate1, Predicate<String> predicate2) {
        List<String> list = new ArrayList<>();
        for (String info : array) {
            if (predicate1.and(predicate2).test(info)) {
                list.add(info);
            }
        }

        return list;
    }

    private static void predicateInterfaceDemo1() {
        predicate2(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("H");
            }
        }, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("W");
            }
        }, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 5;
            }
        });

        predicate2(
                s -> s.startsWith("H"),
                s -> s.contains("W"),
                s -> s.length() == 5
        );

    }

    private static void predicateInterfaceDemo() {
        // predicate1(new Predicate<String>() {
        //     @Override
        //     public boolean test(String s) {
        //         return s.length() > 4;
        //     }
        // });

        predicate1(s -> s.length() > 4);
    }

    private static void predicate1(Predicate<String> predicate) {
        boolean veryLong = predicate.test("hello");
        System.out.println("字符串很长吗？" + veryLong);
    }

    private static void predicate2(Predicate<String> predicate1, Predicate<String> predicate2, Predicate<String> predicate3) {
        boolean isValid = predicate1.and(predicate2).or(predicate3).test("HelloWorld");
        System.out.println("字符串符合要求吗？" + isValid);
    }
}
