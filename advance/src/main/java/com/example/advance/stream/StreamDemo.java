package com.example.advance.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        test();
        method();
        streamDemo1();
    }

    private static void test() {
        List<String> list = new ArrayList<>();
        list.add("小黑白");
        list.add("小黑黑黑");
        list.add("小白");
        list.add("小明");

        ArrayList<String> filteredList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("小黑") && name.length() == 4) {
                filteredList.add(name);
            }
        }

        for (String name : filteredList) {
            System.out.println(name);
        }
    }

    private static void method() {
        // forEach()
        String[] strings = {"小黑", "小白", "小明"};
        Stream.of(strings).forEach(string -> System.out.println(string));

        System.out.println("-----------------");

        // filter
        Stream.of(strings).filter(s -> s.endsWith("黑")).forEach(string -> System.out.println(string));//小黑

        System.out.println("-----------------");

        // map
        String[] strings1 = {"10", "11", "12"};
        Stream<Integer> integerStream = Stream.of(strings1).map(s -> Integer.parseInt(s));
        System.out.println(Arrays.toString(integerStream.toArray()));//[10, 11, 12]

        System.out.println("-----------------");

        //count
        long count = Stream.of(strings1).count();
        System.out.println(count);//3

        System.out.println("-----------------");

        // limit
        Stream<String> limit = Stream.of(strings1).limit(1);
        System.out.println(Arrays.toString(limit.toArray()));//[10]

        // skip
        Stream<String> skip = Stream.of(strings1).skip(1);
        System.out.println(Arrays.toString(skip.toArray()));//[11, 12]

        // concat
        String[] strings2 = {"20", "21", "22"};
        Stream<String> concat = Stream.concat(Stream.of(strings1), Stream.of(strings2));
        System.out.println(Arrays.toString(concat.toArray()));//[10, 11, 12, 20, 21, 22]
    }

    private static void streamDemo1() {
        List<String> list = new ArrayList<>();
        list.add("小黑白");
        list.add("小黑黑黑");
        list.add("小白");
        list.add("小明");

        // list.stream()
        //     .filter(new Predicate<String>() {
        //         @Override
        //         public boolean test(String s) {
        //             return s.startsWith("小黑");
        //         }
        //     }).filter(new Predicate<String>() {
        //         @Override
        //         public boolean test(String s) {
        //             return s.length() == 4;
        //         }
        //     }).forEach(new Consumer<String>() {
        //         @Override
        //         public void accept(String s) {
        //             System.out.println(s);
        //         }
        //     });

        list.stream()
                .filter(s -> s.startsWith("小黑"))
                .filter(s -> s.length() == 4)
                .forEach(s -> System.out.println(s));
    }
}
