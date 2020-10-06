package com.example.webtomcat.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/response_demo")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置状态码
        resp.setStatus(200);

        // 重定向
        // redirectDemo(req, resp);

        // 流
        // outCharacterDemo(req, resp);
        // outByteDemo(req, resp);

        // 验证码
        verificationCodeDemo(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void redirectDemo(HttpServletRequest req, HttpServletResponse resp) {
        // 设置状态码
        resp.setStatus(302);
        // 设置重定向
        resp.setHeader("location", "./request_mode"); // 相对路径
        resp.setHeader("location", "../request_mode"); // 相对路径
        resp.setHeader("location", "/request_mode"); // 绝对路径


        try {
            resp.sendRedirect("request_demo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出字符流
     *
     * @param req
     * @param resp
     */
    private void outCharacterDemo(HttpServletRequest req, HttpServletResponse resp) {
        // 设置编码
        resp.setCharacterEncoding("UTF-8");

        // 设置响应头
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = null;
        try {
            // 默认编码是ISO-8859-1
            writer = resp.getWriter();
            writer.write("<h1>Hello world! 你好, character</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出字节流
     *
     * @param req
     * @param resp
     */
    private void outByteDemo(HttpServletRequest req, HttpServletResponse resp) {
        // 设置编码
        resp.setCharacterEncoding("UTF-8");

        // 设置响应头
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        ServletOutputStream outputStream = null;
        try {
            outputStream = resp.getOutputStream();
            outputStream.write("<h1>Hello world! 你好, byte</h1>".getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void verificationCodeDemo(HttpServletRequest req, HttpServletResponse resp) {
        int width = 100;
        int height = 50;
        // 1. 创建一个对象，内存中的图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 2. 美化图片
        // 2.1 填充背景色
        Graphics graphics = bufferedImage.getGraphics();// 画笔对象
        graphics.setColor(Color.PINK);// 设置画笔颜色
        graphics.fillRect(0, 0, width, height);
        // 2.2 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);
        // 2.3 生成随机字符串
        String str = "ABCDEFGHIJKLMNOPQRSTUVWSYZabcdefghijklmnopqrstuvwsyz0123456789";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            graphics.drawString(c + "", width / 5 * i, height / 2);
        }

        // 2.4 画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 1; i <= 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            graphics.drawLine(x1, x2, y1, y2);
        }

        // 3. 将图片输出
        try {
            ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
