package com.example.advance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Collection<Integer> coll = new ArrayList<>();

        coll.add(1);
        coll.add(2);
        coll.add(3);

        System.out.println(coll);//[1, 2, 3]

        Iterator<Integer> iterator = coll.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);// 1 2 3
        }
    }
}
