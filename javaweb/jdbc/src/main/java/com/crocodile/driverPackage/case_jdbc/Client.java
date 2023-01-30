package com.crocodile.driverPackage.case_jdbc;

import com.crocodile.driverPackage.case_jdbc.pojo.Score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 *             测试数据库取出数据，进行对象封装
 * @Author：crocodilePole
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/xscj?useSSL=false";
        String user = "root";
        String password = "249174";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "select * from t_score";

        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Score> pojoList = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            int courseId = resultSet.getInt(2);
            int score = resultSet.getInt(3);

            pojoList.add(new Score(id,courseId,score));

        }

        resultSet.close();
        statement.close();
        connection.close();
        System.out.println(pojoList);

    }
}
