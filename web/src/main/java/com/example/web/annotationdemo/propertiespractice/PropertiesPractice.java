package com.example.web.annotationdemo.propertiespractice;

import java.lang.reflect.Method;

@PropertiesConfig(className = "com.example.web.annotationdemo.propertiespractice.Person", methodName = "method")
public class PropertiesPractice {
    public static void main(String[] args) {
        Class<PropertiesPractice> propertiesPracticeClass = PropertiesPractice.class;
        PropertiesConfig declaredAnnotation = propertiesPracticeClass.getAnnotation(PropertiesConfig.class);

        String className = declaredAnnotation.className();
        String methodName = declaredAnnotation.methodName();

        // 加载类进入内存
        try {
            Class<?> aClass = Class.forName(className);
            // 创建对象
            Object object = aClass.newInstance();
            // 获取方法对象
            Method method = aClass.getMethod(methodName);
            // 执行方法
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
