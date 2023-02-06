package com.crocodile.servlet;

import javax.servlet.*;
import java.io.IOException;
/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * servlet:web动态资源开发技术
 *        由web服务器创建对象，并调用
 *        实现，提供的servlet规范接口
 *        1、执行流程
 *        2、生命周期
 *          1、加载和实例化
 *          2、初始化 init() *** 仅执行一次 ***
 *          3、请求处理 service()
 *          4、服务终止 destroy()
 *       3、体系结构
 *          servlet(interface) <-- GenericServlet <-- HttpServlet
 *

 * @Author：crocodilePole
 */
//@WebServlet("/demo")
public class Client implements Servlet {

    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {//提升局部变量作用域：servletConfig
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(getServletConfig());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
