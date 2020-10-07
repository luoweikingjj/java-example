package com.example.webtomcat.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")//只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*")//访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp")//访问所有后缀名为jsp资源时，过滤器都会被执行
//@WebFilter("/*")//访问所有资源时，过滤器都会被执行

/**
 *  dispatcherTypes
 *  1. REQUEST：默认值。浏览器直接请求资源
 * 	2. FORWARD：转发访问资源
 * 	3. INCLUDE：包含访问资源
 * 	4. ERROR：错误跳转资源
 * 	5. ASYNC：异步访问资源
 */
@WebFilter(urlPatterns="/*", dispatcherTypes=DispatcherType.REQUEST)
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");

        //放行
        //filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
