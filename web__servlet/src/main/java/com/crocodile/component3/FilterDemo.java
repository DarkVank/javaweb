package com.crocodile.component3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 *    filter:java web 三大组件之一（servlet filter listener）
 *       过滤器可以见Browser请求拦截下来，处理一些通用操作
 *       实现接口（Filter） @WebFilter
 *    处理逻辑
 *       放行前处理request  放行  放行后处理response
 *
 *    过滤器链：一个web应用可以配置多个过滤器
 *        执行顺序：
 *           根据过滤器的类名自然排序执行
 * @Author：crocodilePole
 */
@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("11");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("22");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void destroy() {

    }
}
