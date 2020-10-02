package com.example.advance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetDemo {
    public static void main(String[] args) {
        hashSetDemo();
        hashSetCustomize();
        linkedHashSetDemo();
    }

    private static void hashSetDemo() {
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(2);
        integerHashSet.add(1);
        integerHashSet.add(3);
        integerHashSet.add(3);

        System.out.println(integerHashSet);//[1, 2, 3]   无序的，元素不可重复
    }

    private static void hashSetCustomize() {
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(new Student("张三", 20));
        studentHashSet.add(new Student("李四", 21));
        studentHashSet.add(new Student("王五", 22));

        for (Student student : studentHashSet) {
            System.out.println(student.getName() + "|" + student.getAge());
            // 张三|20
            // 王五|22
            // 李四|21
        }
    }

    private static void linkedHashSetDemo() {
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();

        integerLinkedHashSet.add(4);
        integerLinkedHashSet.add(2);
        integerLinkedHashSet.add(1);
        integerLinkedHashSet.add(3);
        integerLinkedHashSet.add(4);

        System.out.println(integerLinkedHashSet); //[4, 2, 1, 3]

        Iterator<Integer> iterator = integerLinkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // 4
            // 2
            // 1
            // 3
        }
    }
}
