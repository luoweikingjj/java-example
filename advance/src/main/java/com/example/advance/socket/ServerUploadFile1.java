package com.example.advance.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUploadFile1 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端已启动，等待连接……");

        // 1.创建 ServerSocket对象，绑定端口，开始等待连接
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            // 2.接收连接 accept 方法, 返回 socket 对象.
            Socket acceptSocket = serverSocket.accept();

            new Thread() {
                @Override
                public void run() {
                    try {
                        // 3.通过socket 获取输入流
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(acceptSocket.getInputStream());

                        // 4.创建输出流，保存文件至本地
                        FileOutputStream fileOutputStream = new FileOutputStream("D:\\" + System.currentTimeMillis() + ".jpg");
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len = bufferedInputStream.read(bytes)) != -1) {
                            bufferedOutputStream.write(bytes, 0, len);
                            bufferedOutputStream.flush();
                        }

                        // 5.=======信息回写=========
                        System.out.println("block...");
                        OutputStream outputStream = acceptSocket.getOutputStream();
                        outputStream.write("上传成功".getBytes());
                        outputStream.close();

                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        acceptSocket.close();

                        System.out.println("文件上传已保存");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
