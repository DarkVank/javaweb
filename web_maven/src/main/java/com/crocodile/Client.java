package com.crocodile;

import com.crocodile.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.crocodile.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: mybatis
 *                  基础实现，产生的问题
 *                                 Could not create connection to database server.
 *                          原因：
 *                                1、pom。xml中配置的mysql版本号和本机版本号不同
 *                                      本机版本号：select version() from dual;
 *                                2、mysql版本号过高
 *                                       com.mysql.cj.jdbc.Driver
 * @Author：crocodilePole
 */
public class Client {
    public static void main(String[] args) throws IOException {
        selectAll();

        selectAllMapper();
    }

    public static void selectAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> selectAll = sqlSession.selectList("com.crocodile.mapper.UserMapper.selectAll");
        System.out.println(selectAll);

        sqlSession.close();
    }

    public static void selectAllMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//mapper通过全限定名调用sqlSession中的方法，执行sql xml中的sql
        List<User> users = mapper.selectAll();
        System.out.println(users);

        sqlSession.close();
    }

    /**
     * 抽取sqlSessionFactory部分
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }
}
