package com.example.web.annotationdemo.testdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {
        CalculatorDemo calculatorDemo = new CalculatorDemo();
        Class<? extends CalculatorDemo> aClass = calculatorDemo.getClass();

        // 记录出现的异常次数
        int num = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\bug.txt"));

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(calculatorDemo);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    // e.printStackTrace();
                    // 记录异常情况
                    bufferedWriter.write(method + "出现了异常");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常名称：" + e.getCause());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常原因：" + e.getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("--------------------");
                    bufferedWriter.newLine();

                    num++;
                }
            }
        }

        bufferedWriter.write("本次测试一共出现 " + num + " 次异常");
        bufferedWriter.close();
    }
}
