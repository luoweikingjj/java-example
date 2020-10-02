package com.example.advance;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        demo();
        method1();
        method2();
    }

    private static void demo() {
        Calendar instance = Calendar.getInstance();

        int year = instance.get(Calendar.YEAR);//年
        int month = instance.get(Calendar.MONTH);//月 从0开始
        int dayOfMonth = instance.get(Calendar.DAY_OF_MONTH);//月中的天
        int hour = instance.get(Calendar.HOUR);//小时 12小时制
        int hourOfDay = instance.get(Calendar.HOUR_OF_DAY);//天中的小时 24小时制
        int minute = instance.get(Calendar.MINUTE);//分钟
        int second = instance.get(Calendar.SECOND);//秒
        int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);//周中的天

        int monthPlus = month + 1;
        System.out.print(year + "年" + monthPlus + "月" + dayOfMonth + "日");
    }

    private static void method1() {
        Calendar instance = Calendar.getInstance();

        int year = instance.get(Calendar.YEAR);//年
        int month = instance.get(Calendar.MONTH);//月 从0开始
        int dayOfMonth = instance.get(Calendar.DAY_OF_MONTH);//月中的天
        int monthPlus = month + 1;
        System.out.println(year + "年" + monthPlus + "月" + dayOfMonth + "日"); // 2020年1月31日

        instance.add(Calendar.YEAR, 2);
        instance.add(Calendar.DAY_OF_MONTH, 2);

        int year1 = instance.get(Calendar.YEAR);//年
        int month1 = instance.get(Calendar.MONTH);//月 从0开始
        int dayOfMonth1 = instance.get(Calendar.DAY_OF_MONTH);//月中的天
        int monthPlus1 = month1 + 1;
        System.out.println(year1 + "年" + monthPlus1 + "月" + dayOfMonth1 + "日"); // 2022年2月2日
    }

    private static void method2() {
        Calendar instance = Calendar.getInstance();

        Date time = instance.getTime();
        System.out.println(time); //Fri Jan 31 14:36:06 CST 2020

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));//2020-01-31 14:37:45
    }
}
