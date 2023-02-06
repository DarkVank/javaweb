package com.crocodile.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: Response
 * servlet:web动态资源开发技术
 *        由web服务器创建对象，并调用
 * httpServlet（class）: 开发B/S web项目，针对HTTP协议
 *
 *  Response：
 *           1、设置响应数据
 *              响应行
 *              响应头
 *              响应体
 *           2、重定向
 *            response.sendRedirect("/虚拟路径/资源名")
 *            动态获取虚拟路径
 *                 request.getContextPath();
 *                 response.sendRedirect(request.getContextPath+"/资源名")
 *
 *          特点
 *             1、地址栏发生改变
 *             2、服务器内外资源都可访问
 *             3、两次请求
 *
 *          3、响应字符数据
 *          流不用关闭（随response对象销毁而销毁）
 *          问题：
 *              中文乱码问题 ：response获取的字符输出流，默认编码：ISO-8859-1
 *           解决：
 *              response.setContentType("text/html;charset=utf-8")
 *
 *         4、响应字节数据
 *            读取数据
 *              InputStream()
 *
 *            写出数据
 *            response.getOutputStream();
 *            outputStream.write(字节数据);
 *         推荐使用：commons-io
 *         IOUtils.copy(inputStream,outputStream)

 * urlPattern
 * @Author：crocodilePole
 */

@WebServlet("/ResponseDemo")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("ResponseDemo……");
        //1、       response.setStatus(302);
 //          response.setHeader("location","/web_servlet/另外资源");
        //2、

        String contextPath = request.getContextPath();
//        response.sendRedirect(contextPath+"/ServletTemplate");

        PrintWriter writer = response.getWriter();
        writer.write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request,response);
    }
}
