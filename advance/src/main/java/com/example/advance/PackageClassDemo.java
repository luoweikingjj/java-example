package com.example.advance;


import java.util.ArrayList;

public class PackageClassDemo {
    public static void main(String[] args) {
        test();
        auto();
    }

    private static void test(){
        Byte aByte = new Byte("127"); // -127~127之间
        Short aShort = new Short((short) 1);
        Integer integer = new Integer(1);
        Long aLong = new Long(1L);
        Float aFloat = new Float(1.23F);
        Double aDouble = new Double(1.23);
        Character aCharacter = new Character('a');
        Boolean aBoolean = new Boolean(true);

        System.out.println(aByte.byteValue());
        System.out.println(aShort.intValue());
        System.out.println(integer.intValue());
        System.out.println(aLong.intValue());
        System.out.println(aFloat.intValue());
        System.out.println(aDouble.intValue());
        System.out.println(aCharacter.charValue());
        System.out.println(aBoolean.booleanValue());
    }

    private static void auto(){
        Integer i = 4; // Integer i = new Integer(4);
        i = i + 5; //i.intValue() + 5  =>  9   =>   Integer i = new Integer(9);

        ArrayList<Integer> list = new ArrayList<>(); // 这里指定的类型，是包装类的类型

        list.add(1); //list.add(new Integer(1))

        int a = list.get(0); // list.get(0) => 返回包装类(new Integer(1))；   (new Integer(1)).intValue();
    }
}
