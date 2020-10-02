package com.example.advance.functioninterface;


import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        ConsumerInterfaceDemo();
        ConsumerInterfaceDemo1();
        ConsumerInterfaceDemo2();
    }

    private static void ConsumerInterfaceDemo() {
        // 使用 Consumer 接口
        consumerString(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 使用 Lambda
        consumerString(s -> System.out.println(s));
    }

    private static void consumerString(Consumer<String> consumer) {
        consumer.accept("hello");
    }

    private static void ConsumerInterfaceDemo1() {
        // 使用 Consumer 接口
        consumeString1(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());// HELLO
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());// hello
            }
        });

        // 使用Lambda
        consumeString1(
                s -> System.out.println(s.toUpperCase()),// HELLO
                s -> System.out.println(s.toLowerCase())// hello
        );
    }

    private static void consumeString1(Consumer<String> one, Consumer<String> two) {
        //如果一个方法的参数和返回值全都是 Consumer 类型，那么就可以实现效果：消费数据的时候，首先做一个操作，然后再做一个操作，实现组合。
        one.andThen(two).accept("Hello");
    }

    private static void ConsumerInterfaceDemo2() {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};

        printInfo(
                s -> System.out.print("姓名：" + s.split(",")[0]),
                s -> System.out.println("|性别：" + s.split(",")[1] + "。"),
                array
        );
    }

    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info); // 姓名：迪丽热巴。性别：女。
        }
    }
}
