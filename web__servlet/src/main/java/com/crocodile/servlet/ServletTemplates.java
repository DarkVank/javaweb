package com.crocodile.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
 *   Request中 表单提交乱码问题（tomcat8以后url编码 字符集采用了utf-8,和浏览器url编码字符集相符合）
 *           注：
 *             tomcat8以后Get提交方式不存在乱码问题
 *             1、post中文乱码问题 getReader()
 *               request.setCharacterEncoding("utf-8")
 *             2、get解决中文乱码问题
 *              原因：
 *                地址栏传递参数进行url编码（utf-8字符集标准）
 *                    1、参数转为二进制位
 *                    2、每个字节转为两个十六进制数并加上%
 *                通过Java提供的字符编解码处理
 *                new String(string.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8)
 *
 */

@WebServlet("/ServletTemplate")
public class ServletTemplates extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servletTemplates……");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doGet(request,response);
    }
}
