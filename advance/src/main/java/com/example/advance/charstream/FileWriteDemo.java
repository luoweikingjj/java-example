package com.example.advance.charstream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) {
        // test();
        // method();
        flushDemo();
    }

    private static void flushDemo() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\b.txt");
            fileWriter.write("a");
            fileWriter.flush();

            fileWriter.write("b");
            fileWriter.flush();

            fileWriter.write("c");
            fileWriter.close();

            // fileWriter.write("d");//java.io.IOException: Stream closed
            // fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void method() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\b.txt");
            fileWriter.write("abc");

            char[] chars = "abc".toCharArray();
            fileWriter.write(chars);

            fileWriter.write("abcdef".toCharArray(), 3, 3);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\b.txt");

            File file = new File("D:\\b.txt");
            FileWriter fileWriter1 = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
