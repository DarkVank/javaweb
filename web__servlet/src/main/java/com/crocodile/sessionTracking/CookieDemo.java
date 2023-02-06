package com.crocodile.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * 会话跟踪技术：
 *    多次请求之间共享数据
 *  cookie:客户端会话技术，数据存储到客户端
 *       后端处理的问题
 *         1、cookie的创建
 *            new Cookie(String key , String value)
 *            response.addCookie()
 *         2、cookie的获取(遍历map集合，根据键获取值)
 *            request.getCookies()
 *
 *       原理：基于http协议
 *         1、响应头：set-cookie
 *         2、请求头：cookie
 *
 *       cookie存活时间
 *             默认，随浏览器的关闭而消毁(负数)
 *             配置：
 *                setMaxAge(int seconds)
 *                零：此时销毁
 *       cookie：传输中文
 *          当前版本可以传输中文信息
 *          可url编码处理：
 *             URLEncode.encode(value,"utf-8")
 *             URLDecode.decode(value,"utf-8")
 *
 *
 *
 * @Author：crocodilePole
 */
@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("user", "你");
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        for (Cookie item : cookies) {
            String name = item.getName();
            if(name.equals("user")){
                String value = item.getValue();
                System.out.println(value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
