package com.example.advance.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) {
        try {
            System.out.println(97);

            PrintStream printStream = new PrintStream("D:\\ps.txt");
            System.setOut(printStream);

            System.out.println(97);//控制台没有输出，但是文件由输出

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
