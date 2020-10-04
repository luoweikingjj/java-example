package com.example.webtomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/url_pattern_1", "/url_pattern_2", "/url_pattern_3"})
//@WebServlet("url/pattern/1")
@WebServlet("url/pattern/wildcard/*")
public class ServletUrlPatternDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do Get...");
    }
}
