package com.example.advance;

public class StringTransformDemo {
    public static void main(String[] args) {
        toStringMethod();
    }

    private static void toStringMethod() {
        // 基本类型转为String
        // 1. 直接转换
        String str = 24 + "abc";

        // 2. 通过包装类  toString()
        Integer integer = new Integer(1);
        String str1 = integer.toString();

        // 3. 使用 String 类的 valueOf 方法
        String str2 = String.valueOf(24);
    }

    private static void stringToMethod(){
        // String 转为其他，通过包装类来实现
        String str = "abc";
        byte b = Byte.parseByte(str);
        short i1 = Short.parseShort(str);
        int i = Integer.parseInt(str);
        long l = Long.parseLong(str);
        float v = Float.parseFloat(str);
        double v1 = Double.parseDouble(str);
        // Character 没有转换方法
        boolean b1 = Boolean.parseBoolean(str);

        System.out.println(b);
        System.out.println(i1);
        System.out.println(i);
        System.out.println(l);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(b1);
    }
}
