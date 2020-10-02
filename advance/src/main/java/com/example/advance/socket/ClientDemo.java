package com.example.advance.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");

        // 1.创建 Socket ( ip , port ) , 确定连接到哪里.
        Socket socket = new Socket("localhost", 6666);

        // 2.获取流对象. 输出流
        OutputStream outputStream = socket.getOutputStream();

        // 3.写出数据.
        outputStream.write("你好么? tcp ,我来了".getBytes());

        // ==============解析回写=============
        // 4. 通过Socket,获取输入流对象
        InputStream inputStream = socket.getInputStream();

        // 5. 读取数据数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        // 6. 关闭资源
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
