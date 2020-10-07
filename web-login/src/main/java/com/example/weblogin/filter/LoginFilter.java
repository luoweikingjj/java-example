package com.example.weblogin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 强制转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        // 2. 获取资源请求路径
        String requestURI = httpServletRequest.getRequestURI();
        // 3. 判断是否包含登录的相关资源路径
        if (requestURI.contains("/login.jsp") || requestURI.contains("/checkCodeServlet") || requestURI.contains("/loginServlet")) {
            // 包含，想登录，放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 不包含，判断是否登录
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                // 已登录，放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // 没有登录，跳转至登录页
                httpServletRequest.setAttribute("req_error", "您尚未登录，请登录");
                httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
