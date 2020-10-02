package com.example.advance.bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        test();
        method();
        flushDemo();
    }

    private static void test() {
        try {
            FileOutputStream fileOutputStream1 = new FileOutputStream("D:\\a.txt");

            File file = new File("D:\\a.txt");
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.txt", true);//追加
            fileOutputStream.write(97);//a
            fileOutputStream.write(98);//b
            fileOutputStream.write(99);//c

            String string = "abc";
            fileOutputStream.write(string.getBytes());//abc

            String string1 = "abcdef";
            fileOutputStream.write(string1.getBytes(), 3, 3);//def

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void flushDemo() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.txt");

            fileOutputStream.write("a".getBytes());
            fileOutputStream.flush();

            fileOutputStream.write("b".getBytes());
            fileOutputStream.flush();

            fileOutputStream.write("c".getBytes());
            fileOutputStream.close();

            // fileOutputStream.write("d".getBytes());//java.io.IOException: Stream closed
            // fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
