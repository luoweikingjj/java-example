package com.example.advance.bufferedstream;

import java.io.*;
import java.util.*;

public class BufferStreamDemo {
    public static void main(String[] args) {
        test();
        method();
        practice();
    }

    private static void test() {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\a.txt"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\b.txt"));
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\b.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\d.txt"));
            bufferedWriter.write("key1=value1\n");
            bufferedWriter.write("key2=value2\n");
            bufferedWriter.write("key3=value3\n");
            bufferedWriter.newLine();
            bufferedWriter.write("key4=value4");
            bufferedWriter.newLine();
            bufferedWriter.write("key5=value5");
            bufferedWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\d.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void practice() {
        //排序
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\d.txt"));
            bufferedWriter.write("key5=value5\n");
            bufferedWriter.write("key4=value4\n");
            bufferedWriter.write("key3=value3\n");
            bufferedWriter.write("key2=value2\n");
            bufferedWriter.write("key1=value1");
            bufferedWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\d.txt"));
            String line;
            HashMap<String, String> lineMap = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("=");
                lineMap.put(split[0], split[1]);
            }
            bufferedReader.close();
            System.out.println(lineMap);

            // 排序
            // 通过ArrayList构造函数把map.entrySet()转换成list
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(lineMap.entrySet());
            // 通过比较器实现比较排序
            Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
                    return mapping1.getKey().compareTo(mapping2.getKey());
                }
            });

            for (Map.Entry<String, String> mapping : list) {
                System.out.println(mapping.getKey() + "=" + mapping.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
