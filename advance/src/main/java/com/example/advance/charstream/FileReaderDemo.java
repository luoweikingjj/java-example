package com.example.advance.charstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderDemo {
    public static void main(String[] args) {
        test();
        method();
    }

    private static void test() {
        try {
            FileReader fileReader = new FileReader("D:\\b.txt");

            File file = new File("D:\\b.txt");
            FileReader fileReader1 = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method() {
        try {
            FileReader fileReader = new FileReader("D:\\b.txt");
            System.out.println(fileReader.read());//97
            System.out.println(fileReader.read());//98
            System.out.println(fileReader.read());//99
            System.out.println(fileReader.read());//97
            System.out.println(fileReader.read());//98
            System.out.println(fileReader.read());//99
            System.out.println(fileReader.read());//100
            System.out.println(fileReader.read());//101
            System.out.println(fileReader.read());//102
            System.out.println(fileReader.read());//-1

            System.out.println("-------------------------");

            FileReader fileReader1 = new FileReader("D:\\b.txt");
            int b;
            while ((b = fileReader1.read()) != -1) {
                System.out.println(b); //效果同上
            }
            System.out.println("-------------------------");

            FileReader fileReader2 = new FileReader("D:\\b.txt");
            char[] bb = new char[3];//创建字符数组，用来存储数据，每次读取三个字节，起到缓冲的作用
            while (fileReader2.read(bb) != -1) {
                System.out.println(new String(bb));
                //abc
                //abc
                //def
            }
            System.out.println("-------------------------");

            FileReader fileReader3 = new FileReader("D:\\b.txt");
            char[] cc = new char[4];
            System.out.println(fileReader3.read(cc));//4
            System.out.println(new String(cc));//abca
            System.out.println(fileReader3.read(cc));//4
            System.out.println(new String(cc));//bcde
            System.out.println(fileReader3.read(cc));//1
            System.out.println(new String(cc));//fcde
            System.out.println(fileReader3.read(cc));//-1

            System.out.println("-------------------------");

            FileReader fileReader4 = new FileReader("D:\\b.txt");
            char[] dd = new char[4];
            int len;
            while ((len = fileReader4.read(dd)) != -1) {
                System.out.println(new String(Arrays.copyOfRange(dd, 0, len)));
                //abca
                //bcde
                //f
            }

            fileReader.close();
            fileReader1.close();
            fileReader2.close();
            fileReader3.close();
            fileReader4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
