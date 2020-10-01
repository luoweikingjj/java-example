package com.example.basic;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // test();
        operator();
    }

    private static void test(){
        ArrayList<String> strings = new ArrayList<String>();

        System.out.println(strings);

        strings.add("元素1");
        strings.add("元素2");
        strings.add("元素3");
        // strings.add(111); // 出错！因为在创建ArrayList对象时，指定只能存放 String 类型的数据

        System.out.println(strings);
    }

    private static void operator(){
        ArrayList<Integer> integers = new ArrayList<Integer>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        integers.remove(0);//移除1

        System.out.println(integers);
        System.out.println(integers.size());
    }
}
