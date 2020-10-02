package com.example.advance.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientUploadFile {
    public static void main(String[] args) throws IOException {
        // 1.创建流对象
        // 1.1 创建输入流,读取本地文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\avatar.jpg"));
        // 1.2 创建输出流,写到服务端
        Socket socket = new Socket("localhost", 6666);

        // 2. 写出数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
            bufferedOutputStream.flush();
        }
        socket.shutdownOutput();
        System.out.println("文件发送完毕");

        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("文件上传完毕 ");
    }
}
