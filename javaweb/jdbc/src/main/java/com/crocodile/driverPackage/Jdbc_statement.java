package com.crocodile.driverPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * //statement:1、执行sql语句
 *               ~executeUpdate：DML（操作） DDL（定义） int
 *               ~executeQuery :DQL （查询）           resultSet
 *                   next()  get***(列号)  列号：从1开始
 * @Author：crocodilePole
 */
public class Jdbc_statement {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/mi?useSSL=false";
        String user = "root";
        String password = "249174";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "select * from category ";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            long anInt = resultSet.getLong(1);
            System.out.println(anInt);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
