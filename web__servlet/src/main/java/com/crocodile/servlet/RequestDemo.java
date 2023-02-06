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
 * 参考文档： JavaEE api
 *
 * servlet:web动态资源开发技术
 *        由web服务器创建对象，并调用
 * httpServlet（class）: 开发B/S web项目，针对HTTP协议
 *
 *    request:
 *       1、继承体系
 *         servletRequest（请求对象的根接口） <-- httpServletRequest（Java根据http协议封装的接口） <-- RequestFacade (web服务器创实现类)
 *       2、请求数据
 *          get post:request将请求数据封装成map集合
 *          getParameterMap()
 *          getParameterValues(String name)
 *          getParameter(String name)(常用)
 *
 *          通用请求方式
 *           1、逻辑处理方式都放到doGet中处理
 *              String getParameter(String name)
 *           2、servlet模板：
 *                     （可修改 file and code Templates）
 *              project structure ---> facets(开启)
 *              注：
 *                应该是面向切面编程
 *                配置类路径，进行功能增强
 *
 *        3、服务器内部：request请求转发（Browser url not change  一次请求，多部处理）
 *           实现：
 *             req。getRequestDispatcher("资源路径B").forward(req,resp)
 *           作用
 *             1、分布处理
 *             2、数据共享
 *                setAttribute(String name,Object o):存储数据到request域中
 *                getAttribute(String name)
 *                removeAttribute(String name)
 *
 *
 *       路径问题：（是否添加虚拟路径）
 *          浏览器使用（服务器浏览器交互）
 *          服务器内部使用（不用）
 * @Author：crocodilePole
 */
@WebServlet("/request")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
