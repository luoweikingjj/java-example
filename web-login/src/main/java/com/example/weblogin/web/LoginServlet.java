package com.example.weblogin.web;

import com.example.weblogin.dao.UserDao;
import com.example.weblogin.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
//        //2.获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3.封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        // 验证验证码
        String checkCode = req.getParameter("check_code");
        String checkCodeSession = (String) req.getSession().getAttribute("check_code_session");
        // 不管是否通过，验证码只能验证一次
        req.getSession().removeAttribute("check_code_session");
        if (checkCodeSession == null || !checkCodeSession.equalsIgnoreCase(checkCode)) {
            req.setAttribute("req_error", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            // BeanUtils工具类，简化数据封装
            Map<String, String[]> parameterMap = req.getParameterMap();
            User loginUser = new User();
            try {
                BeanUtils.populate(loginUser, parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            //4.调用UserDao的login方法
            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);

            //5.判断user
            if (user == null) {
                //登录失败
                req.getRequestDispatcher("/failServlet").forward(req, resp);
            } else {
                //登录成功
                //存储数据
                req.setAttribute("user", user);
                req.getSession().setAttribute("user", user);
                //转发
                req.getRequestDispatcher("/successServlet").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
