package com.example.webtomcat.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servlet_download")
public class ServletDownloadDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数，文件名称
        String filename = req.getParameter("filename");
        // 2. 使用字节输入流加载文件进内存
        // 2.1 找到文件服务器路径
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        // 2.2 用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 3. 设置response的响应头
        // 3.1 设置向应用类型:content-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);
        // 文件名包含中文处理
        String userAgent = req.getHeader("UserAgent");
        userAgent = (userAgent == null) ? "" : userAgent;
        filename = DownloadUtils.getFileName(userAgent, filename);
        // 3.2 设置响应头打开方式:content-disposition
        resp.setHeader("content-disposition", "attachment;filename="+filename);
        // 4. 将输入流的数据写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
