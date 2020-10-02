package com.example.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class GenericWildDemo {
    public static void main(String[] args) {
        simple();
        advance();
    }

    private static void simple() {
        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);

        Collection<String> strings = new ArrayList<>();
        strings.add("test");

        getElement(integers);
        getElement(strings);
    }

    /**
     * 泛型通配符
     * @param collection
     */
    private static void getElement(Collection<?> collection) {
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
    }

    private static void advance() {
        Collection<Integer> integers = new ArrayList<>();
        Collection<String> strings = new ArrayList<>();
        Collection<Number> numbers = new ArrayList<>();
        Collection<Object> objects = new ArrayList<>();

        getElement1(integers); // Integer类 是 Number 类的子类
        // getElement1(strings);// 报错
        getElement1(numbers);
        // getElement1(objects);// 报错

        // getElement2(integers);// 报错
        // getElement2(strings);// 报错
        getElement2(numbers);
        getElement2(objects);// Object类是所有类的父类
    }

    /**
     * 泛型的上限
     * @param collection
     */
    private static void getElement1(Collection<? extends Number> collection) {
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
    }

    /**
     * 泛型的下限
     * @param collection
     */
    private static void getElement2(Collection<? super Number> collection) {
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
