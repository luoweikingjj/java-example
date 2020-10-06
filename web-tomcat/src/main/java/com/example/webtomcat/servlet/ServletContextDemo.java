package com.example.webtomcat.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet_context")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getServletContextDemo(req, resp);
        // getMimeTypeDemo(req, resp);
        // attributeDemo(req, resp);
        getRealPathDemo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private void getServletContextDemo(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext1 = req.getServletContext();
        System.out.println(servletContext1);
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext2);

        System.out.println(servletContext1 == servletContext2);//true
    }

    private void getMimeTypeDemo(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        String file = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1275750276,2595822322&fm=26&gp=0.jpg";
        System.out.println(servletContext.getMimeType(file));// image/jpeg
    }

    /**
     * 域对象
     *
     * @param req
     * @param resp
     */
    private void attributeDemo(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("test_attribute", "test_attribute_value");
    }

    private void getRealPathDemo(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        String realPathA = servletContext.getRealPath("/a.txt");
        System.out.println(realPathA);// D:\code\java-example\out\artifacts\web_tomcat_Web_exploded\a.txt


        String realPathB = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println(realPathB);//D:\code\java-example\out\artifacts\web_tomcat_Web_exploded\WEB-INF\b.txt
    }

}
