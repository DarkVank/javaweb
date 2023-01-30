package com.crocodile.driverPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * //connection:1、获取执行对象 statement
 *              2、管理事务
 * @Author：crocodilePole
 */
public class Jdbc_connection {

    //事务
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/mi?useSSL=false";
        String user = "root";
        String password = "249174";

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "update category set type =2 where id = 1397844263642378242";
        String sql2 = "update category set type =2 where id = 1397844303408574465";

        //语句：传递sql
        Statement statement = connection.createStatement();

        try {
            //开启事务
            connection.setAutoCommit(false);

            int i = statement.executeUpdate(sql);
            System.out.println(i);
            int wrong = 3/0;//人为异常：测试事务回滚
            int i1 = statement.executeUpdate(sql2);
            System.out.println(i1);

        } catch (Exception e) {

            connection.rollback();
            e.printStackTrace();
        }
        connection.commit();

        statement.close();
        connection.close();

    }
}
