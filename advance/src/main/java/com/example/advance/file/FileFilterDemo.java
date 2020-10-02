package com.example.advance.file;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        File dir = new File("D:\\aaa");

        printDir(dir);
    }

    private static void printDir(File dir){
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().startsWith("a") || pathname.isDirectory();
            }
        });

        for (File file : files) {
            if (file.isDirectory()) {
                printDir(file);
            } else {
                System.out.println("文件名:" + file.getAbsolutePath());
            }
        }
    }

    private static void printDirLambda(File dir){
        File[] files = dir.listFiles(pathname -> {
            return pathname.getName().startsWith("a") || pathname.isDirectory();
        });

        for (File file : files) {
            if (file.isDirectory()) {
                printDir(file);
            } else {
                System.out.println("文件名:" + file.getAbsolutePath());
            }
        }
    }
}
