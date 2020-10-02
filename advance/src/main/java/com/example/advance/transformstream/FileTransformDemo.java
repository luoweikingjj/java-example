package com.example.advance.transformstream;

import java.io.*;

public class FileTransformDemo {
    public static void main(String[] args) throws IOException {
        // 1.定义文件路径
        String srcFile = "file_gbk.txt";
        String destFile = "file_utf8.txt";
        // 2.创建流对象
        // 2.1 转换输入流,指定GBK编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
        // 2.2 转换输出流,默认utf8编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile));
        // 3.读写数据
        // 3.1 定义数组
        char[] charsBuffered = new char[1024];
        // 3.2 定义长度
        int len;
        // 3.3 循环读取
        while ((len = isr.read(charsBuffered)) != -1) {
            // 循环写出
            osw.write(charsBuffered, 0, len);
        }
        // 4.释放资源
        osw.close();
        isr.close();
    }
}
