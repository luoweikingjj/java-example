package com.example.advance.socket;

import java.io.*;
import java.net.Socket;

public class ClientUploadFile1 {
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

        // 3.=======解析回写=========
        InputStream inputStream = socket.getInputStream();
        byte[] backByte = new byte[128];
        inputStream.read(backByte);
        String msg = new String(backByte);
        System.out.println("回写数据：" + msg);
        inputStream.close();

        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("文件上传完毕 ");
    }
}
