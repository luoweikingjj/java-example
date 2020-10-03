package com.example.web.reflectdemo.practice;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class PracticeDemo {
    public static void main(String[] args) throws Exception {
        // 读取配置文件，调用配置中，指定类的指定方法

        // 获取当前文件的位置
        ClassLoader classLoader = PracticeDemo.class.getClassLoader();
        // D:\code\java-demo\advance\src\pro.properties
        // pro.properties
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        // 载入配置
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        // 读取配置
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        System.out.println(className);

        // 加载类进入内存
        Class<?> aClass = Class.forName(className);
        // 创建对象
        Object object = aClass.newInstance();
        // 获取方法对象
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.invoke(object);
    }
}
