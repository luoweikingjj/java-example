package com.example.advance.transformstream;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\File_GBK.txt");
        int read;
        while ((read = fileReader.read()) != -1) {
            System.out.print((char)read);// 输出���乱码，因为IDEA默认是UTF-8编码，而文本是GBK编码
        }
        fileReader.close();
    }
}
