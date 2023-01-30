package com.crocodile.driverPackage.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description：数据库连接池
 *                 官方提供数据库连接池标准接口，第三方实现此接口
 *                 实现：资源复用
 *
 * @Author：crocodilePole
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //获取当前路径
//        System.out.println(System.getProperty("user.dir"));
        druid();
    }

    public static void druid() throws Exception {
        //1、导入jar包  2、定义配置文件 3、加载配置文件 4、 获取连接池对象

        //3
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/java/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        String sql = "select * from category";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            long anLong = resultSet.getLong(1);
            String string = resultSet.getString(3);

            System.out.println(anLong+" "+string);
        }


        connection.close();



    }
}
