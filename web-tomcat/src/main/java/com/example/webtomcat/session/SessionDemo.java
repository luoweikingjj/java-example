package com.example.webtomcat.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session_demo")
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // quickStart(req, resp);
        sessionIdDemo1(req, resp);
        sessionIdDemo2(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void quickStart(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("session_name", "session_value");
    }

    /**
     * 当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
     *
     * @param req
     * @param resp
     */
    private void sessionIdDemo1(HttpServletRequest req, HttpServletResponse resp) {
        // 默认情况下。不是。如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
        HttpSession session = req.getSession();
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60 * 60);
        resp.addCookie(c);
    }

    /**
     * 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
     *
     * @param req
     * @param resp
     */
    private void sessionIdDemo2(HttpServletRequest req, HttpServletResponse resp) {
        // 不是。
    }
}
