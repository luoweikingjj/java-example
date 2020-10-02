package com.example.advance;

import java.io.FileNotFoundException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            // read("a.txt");
            read("b.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("无论异常是否发生，都需要执行");
        }

        System.out.println("结束");
    }

    private static void read(String path) throws FileNotFoundException {
        if (!path.equals("a.txt")) {//如果不是 a.txt这个文件
            // 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
            throw new FileNotFoundException("文件不存在");
        }
    }
}
