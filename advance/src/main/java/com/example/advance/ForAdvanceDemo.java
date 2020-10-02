package com.example.advance;

import java.util.ArrayList;
import java.util.Collection;

public class ForAdvanceDemo {
    public static void main(String[] args) {
        // 目标只能是数组或者Collection

        int[] arr = {1, 2, 3};
        for (int i : arr) {
            System.out.println(i); // 1 2 3
        }

        Collection<Integer> coll = new ArrayList<>();
        coll.add(1);
        coll.add(2);
        coll.add(3);

        for (int i : coll) {
            System.out.println(i); // 1 2 3
        }
    }
}
