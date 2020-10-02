package com.example.advance.file;

import java.io.File;

public class DiGuiDemo2 {
    public static void main(String[] args) {
        File dir = new File("D:\\aaa");

        printDir(dir);
    }

    private static void printDir(File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("目录:" + file.getAbsolutePath());
                printDir(file);
            } else {
                if (file.getName().startsWith("a")) {
                    System.out.println("文件名:" + file.getAbsolutePath());
                }
            }
        }
    }
}
