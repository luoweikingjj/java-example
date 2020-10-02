package com.example.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Collection<Integer> coll = new ArrayList<>();

        coll.add(1);
        coll.add(2);
        coll.add(3);
        System.out.println(coll);//[1, 2, 3]

        coll.remove(1);
        System.out.println(coll);//[2, 3]

        System.out.println(coll.contains(1));//false
        System.out.println(coll.contains(2));//true

        System.out.println(coll.size());//2

        Object[] objects = coll.toArray();
        System.out.println(Arrays.toString(objects));//[2, 3]
    }
}
