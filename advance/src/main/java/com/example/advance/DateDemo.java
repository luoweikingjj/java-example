package com.example.advance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        // test();
        birthday();
    }

    private static void test() throws ParseException {
        System.out.println(new Date());//Fri Jan 31 14:03:16 CST 2020
        System.out.println(new Date(0L));//Thu Jan 01 08:00:00 CST 1970
        System.out.println(new Date(1580450858561L));//Fri Jan 31 14:07:38 CST 2020

        Date date = new Date();
        System.out.println(date.getTime());//1580450986039

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        String str = "2019-02-02 18:20:13";
        // String str = "2019年02月02日"; // 必须和规则一一对应，否则解析异常
        System.out.println(simpleDateFormat.parse(str));
    }

    private static void birthday() throws ParseException {
        System.out.println("请输入出生日期 格式 YYYY-MM-dd");// 获取出生日期,键盘输入
        String birthdayString = new Scanner(System.in).next();
        // 将字符串日期,转成Date对象
        // 创建SimpleDateFormat对象,写日期模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 调用方法parse,字符串转成日期对象
        Date birthdayDate = sdf.parse(birthdayString);
        // 获取今天的日期对象
        Date todayDate = new Date();
        // 将两个日期转成毫秒值,Date类的方法getTime
        long birthdaySecond = birthdayDate.getTime();
        long todaySecond = todayDate.getTime();
        long second = todaySecond - birthdaySecond;
        if (second < 0) {
            System.out.println("还没出生呢");
        } else {
            System.out.println(second / 1000 / 60 / 60 / 24);
        }
    }
}
