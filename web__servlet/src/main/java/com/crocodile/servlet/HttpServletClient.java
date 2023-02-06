package com.crocodile.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * servlet:web动态资源开发技术
 *        由web服务器创建对象，并调用
 *
 * httpServlet（class）: 开发B/S web项目，针对HTTP协议
 *
 *
 * urlPattern
 * @Author：crocodilePole
 */
@WebServlet("/demo")
public class HttpServletClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(11);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
