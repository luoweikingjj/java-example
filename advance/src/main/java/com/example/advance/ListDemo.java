package com.example.advance;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {
    public static void main(String[] args) {
        arrayListDemo();
        linkedListDemo();
    }

    private static void arrayListDemo() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(3);

        System.out.println(integers);//[2, 1, 3]

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
            // 2
            // 1
            // 3
        }
        System.out.println("-------------");

        for (int integer : integers) {
            System.out.println(integer);
            // 2
            // 1
            // 3
        }
    }

    private static void linkedListDemo() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(2);
        integers.add(1);
        integers.add(3);
        integers.addFirst(4);

        System.out.println(integers);//[4, 2, 1, 3]

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
            // 4
            // 2
            // 1
            // 3
        }
        System.out.println("-------------");

        for (int integer : integers) {
            System.out.println(integer);
            // 4
            // 2
            // 1
            // 3
        }
        System.out.println("-------------");

        while (!integers.isEmpty()) { //判断集合是否为空
            System.out.println(integers.pop()); //弹出集合中的栈顶元素
            // 4
            // 2
            // 1
            // 3
        }
    }
}
