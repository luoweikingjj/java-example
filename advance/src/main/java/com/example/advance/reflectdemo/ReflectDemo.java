package com.example.advance.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {
    public static void main(String[] args) {
        // getClassDemo();
        // getFieldDemo();
        // getMethodDemo();
        getConstructorDemo();
    }

    private static void getConstructorDemo() {
        try {
            Class<?> aClass = Class.forName("com.demo.advance.reflectdemo.Person");

            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println(Arrays.toString(constructors));

            Constructor<?> constructor1 = aClass.getConstructor();
            Constructor<?> constructor2 = aClass.getConstructor(String.class);
            System.out.println(constructor1);
            System.out.println(constructor2);

            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            System.out.println(Arrays.toString(declaredConstructors));

            Constructor<?> publicConstructor = aClass.getDeclaredConstructor(String.class);
            Constructor<?> protectedConstructor = aClass.getDeclaredConstructor(String.class, String.class);
            Constructor<?> defaultConstructor = aClass.getDeclaredConstructor(String.class, String.class, String.class);
            Constructor<?> privateConstructor = aClass.getDeclaredConstructor(String.class, String.class, String.class, String.class);
            System.out.println(publicConstructor);
            System.out.println(protectedConstructor);
            System.out.println(defaultConstructor);
            System.out.println(privateConstructor);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getMethodDemo() {
        try {
            Class<?> aClass = Class.forName("com.demo.advance.reflectdemo.Person");

            // 获取 public 的 method
            Method[] methods = aClass.getMethods();
            System.out.println(methods);

            // 获取
            Method getA = aClass.getMethod("getA");
            System.out.println(getA);

            // 获取 有形参
            Method setA = aClass.getMethod("setA", String.class);
            System.out.println(setA);

            // 获取 declared(已声明) 的 method
            Method[] declaredMethods = aClass.getDeclaredMethods();
            System.out.println(Arrays.toString(declaredMethods));

            Method publicMethod = aClass.getDeclaredMethod("publicMethod");
            Method protectedMethod = aClass.getDeclaredMethod("protectedMethod");
            Method defaultMethod = aClass.getDeclaredMethod("defaultMethod");
            Method privateMethod = aClass.getDeclaredMethod("privateMethod");

            System.out.println(publicMethod);
            System.out.println(protectedMethod);
            System.out.println(defaultMethod);
            System.out.println(privateMethod);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getFieldDemo() {
        try {
            Class<?> aClass = Class.forName("com.demo.advance.reflectdemo.Person");

            // 获取 public 的 field
            Field[] fields = aClass.getFields();
            System.out.println(Arrays.toString(fields));
            Field a = aClass.getField("a");
            System.out.println(a);

            // 获取 declared(已声明) 的 field
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(Arrays.toString(declaredFields));
            Field b = aClass.getDeclaredField("b");
            Field c = aClass.getDeclaredField("c");
            Field d = aClass.getDeclaredField("d");

            //设置可访问的
            b.setAccessible(true);
            c.setAccessible(true);
            d.setAccessible(true);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }


        Person person = new Person();

    }

    private static void getClassDemo() {
        try {
            Class<?> aClass = Class.forName("com.demo.advance.reflectdemo.Person");
            System.out.println(aClass);

            Class<Person> bClass = Person.class;
            System.out.println(bClass);

            Person person = new Person();
            Class<? extends Person> cClass = person.getClass();
            System.out.println(cClass);

            System.out.println(aClass == bClass);
            System.out.println(aClass == cClass);
            System.out.println(bClass == cClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
