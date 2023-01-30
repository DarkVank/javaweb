package com.crocodile.driverPackage;

import java.sql.*;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: 1、预编译sql开启：useServerPrepStmts=true (url?后)
 *                  原理：
 *                      在获取prepareStatement对象时将sql发送给mysql服务器，进行检查编译
 *                      执行命令发出前（executeQuery ……）
 *                  效率高：
 *                      如果模板一样，则仅检查、编译一次
 *                      普通statement：无预编译，每次都是三次操作
 *               2、防止sql注入
 *
 *              preparedStatement:处理statement中的sql注入问题 通过将敏感字符转义处理
 *              sql注入：通过恒等式修改事先定义好的判断条件，达到通过验证的目的  （‘ or '1'='1' ’）
 *
 *              配置MySQL执行日志：
 *              log-output=FILE
 *              general-log=1
 *              general_log_file="自定目录"
 *              slow-query-log=1
 *              slow_query_log_file="自定目录"
 *              long_query_time=2
 * @Author：crocodilePole
 */
public class Jdbc_preparedStatement {

    //sql演示
    public static void main(String[] args) throws Exception {
        sqlTest();
        prepareStatement();
    }

    public static void sqlTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/xscj?useSSL=false";
        String user = "root";
        String password = "249174";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String name = "qq1";
        String passwords = "122";
        String psw = "' or '1' = '1";

        String sql = "select * from test where username = '"+name+"' and password = '"+psw+"'";

        ResultSet resultSet = statement.executeQuery(sql );

        if(resultSet.next()){
            System.out.println("登陆成功");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void prepareStatement() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/xscj?useSSL=false";
        String user = "root";
        String password = "249174";

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from test where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        String name = "qq";
        String passwords = "122";
        String psw = "' or '1' = '1";

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,psw);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("登陆成功！");
        }


        preparedStatement.close();
        connection.close();
    }
}
