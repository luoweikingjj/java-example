package com.example.weblogin.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        // 验证码
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            stringBuilder.append(c);
            graphics.drawString(c + "", width / 5 * i, height / 2);
        }
        // 验证码保存至session
        req.getSession().setAttribute("check_code_session", stringBuilder.toString());

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
