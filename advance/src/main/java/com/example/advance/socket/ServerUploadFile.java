package com.example.advance.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUploadFile {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端已启动，等待连接……");

        // 1.创建 ServerSocket对象，绑定端口，开始等待连接
        ServerSocket serverSocket = new ServerSocket(6666);

        // 2.接收连接 accept 方法, 返回 socket 对象.
        Socket acceptSocket = serverSocket.accept();

        // 3.通过socket 获取输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(acceptSocket.getInputStream());

        // 4.创建输出流，保存文件至本地
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\avatar_save.jpg"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
        acceptSocket.close();
        System.out.println("文件上传已保存");
    }
}
