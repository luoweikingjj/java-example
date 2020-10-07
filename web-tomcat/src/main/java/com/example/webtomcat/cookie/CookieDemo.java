package com.example.webtomcat.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet("/cookie_demo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 快速入门
//        quickStart(req, resp);
//
//        // 持久化
//        setMaxAgeDemo(req, resp);

        // 乱码问题
        garbledDemo(req, resp);

        // 共享问题1
//        pathDemo(req, resp);
//
//        // 共享问题2
//        domainDemo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void quickStart(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie1 = new Cookie("cookie_quick_start1", "cookie_quick_start_value1");
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("cookie_quick_start2", "cookie_quick_start_value2");
        resp.addCookie(cookie2);
    }


    private void setMaxAgeDemo(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("cookie_name", "cookie_value");
        // 设置存活时间，到期后自动消失
        cookie.setMaxAge(10);
        // 当浏览器关闭后，Cookie数据被销毁。默认
        cookie.setMaxAge(-1);
        // 删除cookie
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    /**
     * 乱码问题
     *
     * @param req
     * @param resp
     */
    private void garbledDemo(HttpServletRequest req, HttpServletResponse resp) {
        //Cookie cookie = new Cookie("cookie_name", "你好");
        Cookie cookie = null;
        try {
            cookie = new Cookie("cookie_name", URLEncoder.encode("你好", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.addCookie(cookie);
    }


    /**
     * 共享问题1, 在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
     *
     * @param req
     * @param resp
     */
    private void pathDemo(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("cookie_name", "cookie_value");
        cookie.setPath("/"); // 在 /cookie/get/data 可见
        cookie.setPath("/web_tomcat_Web_exploded/cookie"); // 在 /cookie/get/data 可见
        cookie.setPath("/web_tomcat_Web_exploded/cookie/other"); // 在 /cookie/get/data 不可见

        resp.addCookie(cookie);
    }

    /**
     * 共享问题2,不同的tomcat服务器间cookie共享问题？
     *
     * @param req
     * @param resp
     */
    private void domainDemo(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("cookie_name", "cookie_value");
        cookie.setDomain("*.baidu.com"); // 在 tieba.baidu.com和news.baidu.com 可见
        resp.addCookie(cookie);
    }
}
