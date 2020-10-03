package com.example.web.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {
    public static void main(String[] args) {
        getClassDemo();
        getFieldDemo();
        getMethodDemo();
        getConstructorDemo();
    }

    private static void getClassDemo() {
        try {
            Class<?> aClass = Class.forName("com.example.web.reflectdemo.Person");
            System.out.println(aClass);//class com.example.web.reflectdemo.Person

            Class<Person> bClass = Person.class;
            System.out.println(bClass);//class com.example.web.reflectdemo.Person

            Person person = new Person();
            Class<? extends Person> cClass = person.getClass();
            System.out.println(cClass);//class com.example.web.reflectdemo.Person

            System.out.println(aClass == bClass);//true
            System.out.println(aClass == cClass);//true
            System.out.println(bClass == cClass);//true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getFieldDemo() {
        try {
            Class<?> aClass = Class.forName("com.example.web.reflectdemo.Person");

            // 获取 public 的 field
            Field[] fields = aClass.getFields();
            System.out.println(Arrays.toString(fields));// [public java.lang.String com.example.web.reflectdemo.Person.a]
            Field a = aClass.getField("a");
            System.out.println(a);// public java.lang.String com.example.web.reflectdemo.Person.a

            // 获取 declared(已声明) 的 field
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(Arrays.toString(declaredFields));// [public java.lang.String com.example.web.reflectdemo.Person.a, protected java.lang.String com.example.web.reflectdemo.Person.b, java.lang.String com.example.web.reflectdemo.Person.c, private java.lang.String com.example.web.reflectdemo.Person.d]
            Field b = aClass.getDeclaredField("b");
            Field c = aClass.getDeclaredField("c");
            Field d = aClass.getDeclaredField("d");

            //设置可访问的
            b.setAccessible(true);
            c.setAccessible(true);
            d.setAccessible(true);
            System.out.println(b);//protected java.lang.String com.example.web.reflectdemo.Person.b
            System.out.println(c);//java.lang.String com.example.web.reflectdemo.Person.c
            System.out.println(d);//private java.lang.String com.example.web.reflectdemo.Person.d

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Person person = new Person();
    }

    private static void getMethodDemo() {
        try {
            Class<?> aClass = Class.forName("com.example.web.reflectdemo.Person");

            // 获取 public 的 method
            Method[] methods = aClass.getMethods();
            System.out.println(methods);// [Ljava.lang.reflect.Method;@7f31245a

            // 获取
            Method getA = aClass.getMethod("getA");
            System.out.println(getA);// public java.lang.String com.example.web.reflectdemo.Person.getA()

            // 获取 有形参
            Method setA = aClass.getMethod("setA", String.class);
            System.out.println(setA);// public void com.example.web.reflectdemo.Person.setA(java.lang.String)

            // 获取 declared(已声明) 的 method
            Method[] declaredMethods = aClass.getDeclaredMethods();
            System.out.println(Arrays.toString(declaredMethods));//[public java.lang.String com.example.web.reflectdemo.Person.toString(), public java.lang.String com.example.web.reflectdemo.Person.getA(), public void com.example.web.reflectdemo.Person.publicMethod(), protected void com.example.web.reflectdemo.Person.protectedMethod(), void com.example.web.reflectdemo.Person.defaultMethod(), public void com.example.web.reflectdemo.Person.setA(java.lang.String), private void com.example.web.reflectdemo.Person.privateMethod(), public void com.example.web.reflectdemo.Person.setC(java.lang.String), public void com.example.web.reflectdemo.Person.setB(java.lang.String), public java.lang.String com.example.web.reflectdemo.Person.getB(), public java.lang.String com.example.web.reflectdemo.Person.getD(), public void com.example.web.reflectdemo.Person.setD(java.lang.String), public java.lang.String com.example.web.reflectdemo.Person.getC()]

            Method publicMethod = aClass.getDeclaredMethod("publicMethod");
            Method protectedMethod = aClass.getDeclaredMethod("protectedMethod");
            Method defaultMethod = aClass.getDeclaredMethod("defaultMethod");
            Method privateMethod = aClass.getDeclaredMethod("privateMethod");

            System.out.println(publicMethod);//public void com.example.web.reflectdemo.Person.publicMethod()
            System.out.println(protectedMethod);//protected void com.example.web.reflectdemo.Person.protectedMethod()
            System.out.println(defaultMethod);//void com.example.web.reflectdemo.Person.defaultMethod()
            System.out.println(privateMethod);//private void com.example.web.reflectdemo.Person.privateMethod()

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getConstructorDemo() {
        try {
            Class<?> aClass = Class.forName("com.example.web.reflectdemo.Person");

            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println(Arrays.toString(constructors));// [public com.example.web.reflectdemo.Person(java.lang.String), public com.example.web.reflectdemo.Person()]

            Constructor<?> constructor1 = aClass.getConstructor();
            Constructor<?> constructor2 = aClass.getConstructor(String.class);
            System.out.println(constructor1);// public com.example.web.reflectdemo.Person()
            System.out.println(constructor2);// public com.example.web.reflectdemo.Person(java.lang.String)

            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            System.out.println(Arrays.toString(declaredConstructors));// [private com.example.web.reflectdemo.Person(java.lang.String,java.lang.String,java.lang.String,java.lang.String), com.example.web.reflectdemo.Person(java.lang.String,java.lang.String,java.lang.String), protected com.example.web.reflectdemo.Person(java.lang.String,java.lang.String), public com.example.web.reflectdemo.Person(java.lang.String), public com.example.web.reflectdemo.Person()]

            Constructor<?> publicConstructor = aClass.getDeclaredConstructor(String.class);
            Constructor<?> protectedConstructor = aClass.getDeclaredConstructor(String.class, String.class);
            Constructor<?> defaultConstructor = aClass.getDeclaredConstructor(String.class, String.class, String.class);
            Constructor<?> privateConstructor = aClass.getDeclaredConstructor(String.class, String.class, String.class, String.class);
            System.out.println(publicConstructor);// public com.example.web.reflectdemo.Person(java.lang.String)
            System.out.println(protectedConstructor);// protected com.example.web.reflectdemo.Person(java.lang.String,java.lang.String)
            System.out.println(defaultConstructor);// com.example.web.reflectdemo.Person(java.lang.String,java.lang.String,java.lang.String)
            System.out.println(privateConstructor);// private com.example.web.reflectdemo.Person(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
