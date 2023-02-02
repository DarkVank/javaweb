package com.crocodile.mapper;

import com.crocodile.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: mybatis
 *               mapper代理开发：
 *                  1、保证mapper接口的全限定名和sql xml的spaceName相同
 *                  2、保证mapper接口中方法的返回值和sql xml的resultType相同
 *                  3、核心配置文件：包扫描<package name ="包目录"/>
 *
 *                  注解开发：
 *                    注解完成简单的sql
 *                    xml完成复杂的sql
 *
 * @Author：crocodilePole
 */
public interface UserMapper {

    @Select("select * from test")
    List<User> selectAll();
}
