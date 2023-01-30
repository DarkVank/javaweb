package com.crocodile.driverPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 * jdbc:一套标准接口
 * 各个厂商驱动包：Jdbc的实现类 ( maven中下载)
 * jdbc：使用Java操作关系型数据库的一套API
 * @Author：crocodilePole
 */
public class Jdbc {
    public static void main(String[] args) throws Exception {

        // 1、注册驱动（反射加载类），Driver类中静态代码块：DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/mi?useSSL=false";
        String userName = "root";
        String password = "249174";

        //DriverManager: 管理一组jdbc程序的基本服务
        Connection connection = DriverManager.getConnection(url, userName, password);

        //sql
        String sql = "update category set type = 2 where id = 1397844263642378242 ";

        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);

        connection.close();
        statement.close();

    }
}
