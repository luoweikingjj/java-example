package com.example.webtomcat.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request_demo")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方式
        System.out.println(req.getMethod());// GET
        // 获取虚拟目录
        System.out.println(req.getContextPath());///web_tomcat_Web_exploded
        // 获取Servlet路径
        System.out.println(req.getServletPath());///request_demo
        // 获取get方式请求参数
        System.out.println(req.getRequestURI());///web_tomcat_Web_exploded/request_demo
        // 获取请求URI
        System.out.println(req.getRequestURL());//http://localhost:8080/web_tomcat_Web_exploded/request_demo
        // 获取协议及版本
        System.out.println(req.getProtocol());//HTTP/1.1
        // 获取客户机的IP地址
        System.out.println(req.getRemoteAddr());//0:0:0:0:0:0:0:1
        // 通过请求头的名称获取请求头的值
        System.out.println(req.getHeader("User-Agent"));//Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36
        // 获取所有的请求头名称
        System.out.println(req.getHeaderNames());//org.apache.tomcat.util.http.NamesEnumerator@6bccf9f6

        // 获取请求参数
        getParameter(req, resp);

        // 共享数据
        req.setAttribute("attr_key", "attr_value");

        // 转发
        System.out.println("step 1 ....");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/request_dispatcher_demo");
        requestDispatcher.forward(req, resp);

        // ServletContext
        System.out.println(req.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码问题
        req.setCharacterEncoding("utf-8");

        // 获取字符输入流，只能操作字符数据
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null)  {
            System.out.println(line);
        }

        // 获取请求参数
        getParameter(req, resp);

        // 获取字节输入流，可以操作所有类型数据
//        ServletInputStream inputStream = req.getInputStream();
//        System.out.println(inputStream);
    }


    private void getParameter(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("--------------------------");
        // 获取请求参数
        System.out.println(req.getParameter("username"));//123
        System.out.println(req.getParameter("password"));//123123
        // 根据参数名称获取参数值的数组
        System.out.println(Arrays.toString(req.getParameterValues("value")));//[value1, value2]
        // 获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);// username password value
            System.out.println(req.getParameter(name));// 123 123123 value1
            System.out.println(Arrays.toString(req.getParameterValues(name)));// [123] [123123] [value1, value2]
        }
        System.out.println("--------------------------");
        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String name : strings) {
            System.out.println(Arrays.toString(parameterMap.get(name)));
            // [123]
            // [123123]
            // [value1, value2]
        }
    }
}
