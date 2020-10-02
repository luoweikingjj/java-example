package com.example.advance.file;

import java.io.File;

public class DiGuiDemo1 {
    public static void main(String[] args) {
        File dir = new File("D:\\books");

        printDir(dir);
    }

    private static void printDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("目录:" + file.getAbsolutePath());
                printDir(file);
            } else {
                System.out.println("文件名:" + file.getAbsolutePath());
            }
        }
    }
}
