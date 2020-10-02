package com.example.advance.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\avatar.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\avatar_copy.jpg");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        // 资源关闭顺序：先开后关
        fileOutputStream.close();
        fileInputStream.close();
    }
}
