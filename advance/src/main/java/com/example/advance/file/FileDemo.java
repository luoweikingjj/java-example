package com.example.advance.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        test();
        method();
        listFileDemo();
    }

    /**
     * 一个File对象代表硬盘中实际存在的一个文件或者目录。
     * 无论该路径下是否存在文件或者目录，都不影响File对象的创建。
     */
    private static void test() {
        String pathname = "D:\\a.txt";
        File file = new File(pathname);

        String pathname1 = "D:\\code\\java-demo";
        String child = "a.txt";
        File file1 = new File(pathname1, child);

        File file2 = new File(pathname1);
        File file3 = new File(file2, child);

        System.out.println(file3.getAbsoluteFile());//D:\code\java-demo\a.txt
        System.out.println(file3.getPath());//D:\code\java-demo\a.txt
        System.out.println(file3.getName());//a.txt
        System.out.println(file3.getParent());//D:\code\java-demo
        System.out.println(file3.length());//0
    }

    private static void method() {
        String pathname = "D:\\a.txt";
        File file = new File(pathname);

        String pathname1 = "a.txt";
        File file1 = new File(pathname1);

        System.out.println(file.getAbsoluteFile());//D:\a.txt
        System.out.println(file1.getAbsoluteFile());//D:\code\java-demo\a.txt

        System.out.println(file.exists());//true
        System.out.println(file.isDirectory());//false
        System.out.println(file.isFile());//true

        // 操作
        try {
            File file2 = new File("D:\\test.txt");
            //当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            boolean newFile = file2.createNewFile();
            System.out.println("是否创建:" + newFile);//是否创建:true
            System.out.println(file2.delete());//true
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file3 = new File("D:\\aaa\\bbb");
        System.out.println(file3.mkdir());//false 多级目录调用 mkdirs()

        File file4 = new File("D:\\aaa");
        System.out.println(file4.mkdir());//true

        File file5 = new File("D:\\ccc\\ddd");
        System.out.println(file5.mkdirs());//true
    }

    private static void listFileDemo() {
        File file = new File("D:\\aaa");
        String[] filenames = file.list();

        for (String filename : filenames) {
            System.out.println(filename);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }
}
