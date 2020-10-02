package com.example.advance.bufferedstream;

import java.io.*;

public class BufferedStreamCopy {
    public static void main(String[] args) {
        // byteStreamDemo();
        charStreamDemo();
    }

    private static void charStreamDemo() {
        // 记录开始时间
        long start = System.currentTimeMillis();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\video.mp4"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\video_copy.mp4"));

            char[] chars = new char[1024];
            int len;
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
            }

            long end = System.currentTimeMillis();
            System.out.println("缓冲流复制时间:" + (end - start) + " 毫秒");

            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteStreamDemo() {
        // 记录开始时间
        long start = System.currentTimeMillis();

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\video.mp4"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\video_copy.mp4"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            // 记录结束时间
            long end = System.currentTimeMillis();
            System.out.println("缓冲流复制时间:" + (end - start) + " 毫秒");

            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
