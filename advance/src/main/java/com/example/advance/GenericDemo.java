package com.example.advance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {
        test();
        statement();
        implementsDemo();
    }

    private static void test() {
        Collection<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add("test");// 泛型没有指定数据类型，可以添加了整数后，继续添加字符串

        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());// 1 2 test

            String str = iterator.next().toString(); // 多有种数据类型，所以需要进行数据类型转换
            System.out.println(str);
        }
    }

    private static void statement() {
        MyGenericClass<String> objectMyGenericClass = new MyGenericClass<String>();
        objectMyGenericClass.setMvp("test");//指定泛型类型为 String

        MyGenericClass<Integer> integerMyGenericClass = new MyGenericClass<>();
        integerMyGenericClass.setMvp(1);//指定泛型为 Integer

        integerMyGenericClass.showMVP();// 1
        Object o = integerMyGenericClass.showMVP1();
        System.out.println(o);// 1

        Integer integer = integerMyGenericClass.showMVP2(2);
        System.out.println(integer);// 2
    }

    private static void implementsDemo() {
        MyGenericClass1 myGenericClass1 = new MyGenericClass1();
        myGenericClass1.add("test");//定义类时，已经指定了数据类型，在实例化对象时无需再指定

        MyGenericClass2<Integer> objectMyGenericClass2 = new MyGenericClass2<Integer>();
        objectMyGenericClass2.add(1);//定义类时，未指定数据类型，在实例化对象时需指定数据类型
    }
}
