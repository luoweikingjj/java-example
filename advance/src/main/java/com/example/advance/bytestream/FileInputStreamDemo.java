package com.example.advance.bytestream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        test();
        method();
    }

    private static void test() {
        try {
            FileInputStream fileInputStream1 = new FileInputStream("D:\\a.txt");

            File file = new File("D:\\a.txt");
            FileInputStream fileInputStream2 = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\a.txt");
            System.out.println(fileInputStream.read());//97
            System.out.println(fileInputStream.read());//98
            System.out.println(fileInputStream.read());//99
            System.out.println(fileInputStream.read());//97
            System.out.println(fileInputStream.read());//98
            System.out.println(fileInputStream.read());//99
            System.out.println(fileInputStream.read());//100
            System.out.println(fileInputStream.read());//101
            System.out.println(fileInputStream.read());//102
            System.out.println(fileInputStream.read());//-1

            System.out.println("-------------------------");

            FileInputStream fileInputStream1 = new FileInputStream("D:\\a.txt");
            int b;
            while ((b = fileInputStream1.read()) != -1) {
                System.out.println(b); //效果同上
            }
            System.out.println("-------------------------");

            FileInputStream fileInputStream2 = new FileInputStream("D:\\a.txt");
            byte[] bb = new byte[3];//创建字节数组，用来存储数据，每次读取三个字节，起到缓冲的作用
            while (fileInputStream2.read(bb) != -1) {
                System.out.println(new String(bb));
                //abc
                //abc
                //def
            }
            System.out.println("-------------------------");

            // 读取字节未替换问题
            FileInputStream fileInputStream3 = new FileInputStream("D:\\a.txt");//abcabcdef
            byte[] cc = new byte[4];
            System.out.println(fileInputStream3.read(cc));//4
            System.out.println(new String(cc));//abca
            System.out.println(fileInputStream3.read(cc));//4
            System.out.println(new String(cc));//bcde
            System.out.println(fileInputStream3.read(cc));//1
            System.out.println(new String(cc));//fcde
            System.out.println(fileInputStream3.read(cc));//-1

            System.out.println("-------------------------");

            FileInputStream fileInputStream4 = new FileInputStream("D:\\a.txt");//abcabcdef
            byte[] dd = new byte[4];
            int len;
            while ((len = fileInputStream4.read(dd)) != -1) {
                System.out.println(new String(Arrays.copyOfRange(dd, 0, len)));
                //abca
                //bcde
                //f
            }

            fileInputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();
            fileInputStream3.close();
            fileInputStream4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
