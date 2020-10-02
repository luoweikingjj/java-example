package com.example.advance;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        test();
        customize();
        orderedDemo1();
        orderedDemo2();
        practice();
    }

    private static void test() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("黄晓明", "杨颖");
        stringStringHashMap.put("文章", "马伊琍");
        stringStringHashMap.put("邓超", "孙俪");

        System.out.println(stringStringHashMap);//{邓超=孙俪, 文章=马伊琍, 黄晓明=杨颖}

        stringStringHashMap.remove("文章");
        System.out.println(stringStringHashMap);//{邓超=孙俪, 黄晓明=杨颖}

        System.out.println(stringStringHashMap.get("文章"));//null
        System.out.println(stringStringHashMap.get("黄晓明"));//杨颖

        Set<String> strings = stringStringHashMap.keySet();
        for (String string : strings) {
            String value = stringStringHashMap.get(string);
            System.out.println(string + "的CP是：" + value);//邓超的CP是：孙俪 黄晓明的CP是：杨颖
        }
    }

    private static void customize() {
        HashMap<Student, String> studentStringHashMap = new HashMap<>();
        studentStringHashMap.put(new Student("张三", 20), "1班");
        studentStringHashMap.put(new Student("李四", 21), "2班");
        studentStringHashMap.put(new Student("王五", 22), "3班");

        Set<Map.Entry<Student, String>> entries = studentStringHashMap.entrySet();
        for (Map.Entry entry : entries) {
            Student key = (Student) entry.getKey();
            Object value = entry.getValue();
            System.out.println(key.toString() + "....." + key.getName() + "....." + key.getAge() + "....." + value);
            // com.example.advance.Student@16e8e0c.....张三.....20.....1班
            // com.example.advance.Student@1bb448e.....王五.....22.....3班
            // com.example.advance.Student@18e5429.....李四.....21.....2班
        }

        System.out.println("----------------------");

        Set<Student> students = studentStringHashMap.keySet();
        for (Student student : students) {
            String value = studentStringHashMap.get(student);
            System.out.println(student.toString() + "....." + student.getName() + "....." + student.getAge() + "....." + value);
            // com.example.advance.Student@16e8e0c.....张三.....20.....1班
            // com.example.advance.Student@1bb448e.....王五.....22.....3班
            // com.example.advance.Student@18e5429.....李四.....21.....2班
        }
    }

    private static void orderedDemo1() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("a", "a");
        stringStringHashMap.put("c", "c");
        stringStringHashMap.put("b", "b");
        stringStringHashMap.put("a", "d");
        System.out.println(stringStringHashMap);//{a=d, b=b, c=c}

        System.out.println("-------------------");

        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
        stringStringLinkedHashMap.put("a", "a");
        stringStringLinkedHashMap.put("c", "c");
        stringStringLinkedHashMap.put("b", "b");
        stringStringLinkedHashMap.put("a", "d");
        System.out.println(stringStringLinkedHashMap);//{a=d, c=c, b=b}

        Set<Map.Entry<String, String>> entries = stringStringLinkedHashMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
            // a  d
            // c  c
            // b  b
        }
    }

    private static void orderedDemo2() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("aa", "aa");
        stringStringHashMap.put("ac", "ac");
        stringStringHashMap.put("ab", "ab");
        stringStringHashMap.put("bb", "bb");
        stringStringHashMap.put("cc", "cc");
        System.out.println(stringStringHashMap);//{aa=aa, bb=bb, cc=cc, ab=ab, ac=ac}

        System.out.println("-------------------");

        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(stringStringHashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + "  " + mapping.getValue());
            // aa  aa
            // ab  ab
            // ac  ac
            // bb  bb
            // cc  cc
        }
    }

    private static void practice() {
        System.out.println("请输入一个字符串");//fjslkdjwlkfjlkdjflkwjef

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                Integer integer = map.get(c);
                integer += 1;

                map.put(c, integer);
            }
        }

        System.out.println(map);//{s=1, d=2, e=1, f=4, w=2, j=5, k=4, l=4}
    }
}
