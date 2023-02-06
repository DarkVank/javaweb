package com.crocodile.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 *    session:服务端的会话追踪技术
 *       javaEE提供的HttpSession接口
 *    session原理
 *      基于cookie实现（通过cookie存储session id）
 *
 * @Author：crocodilePole
 */
public class SessionDemo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user","object");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
