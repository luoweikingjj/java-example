package com.example.web.annotationdemo;

// extends java.lang.annotation.Annotation
public @interface MyAnnotation {
    // 基础数据类型
    byte bytePro();
    short shortPro();
    int intPro();
    long longPro();
    float floatPro();
    double doublePro();
    char charPro();
    boolean booleanPro();

    // String
    String stringPro();

    // 枚举
    MyEnum myEnum();

    // 注解
    Annotation1 annotation1();

    // 以上类型的数组
    String[] strings();
    String[] strings1() default {"1", "2"};
}
