package com.crocodile.component3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:
 *    listener: 监听器 监听 application、session、request 三个对象的生命
 *       Java web 提供了8个监听器
 *         主：servletContextListener  监听servletContext的创建和销毁
 * @Author：crocodilePole
 */
public class ListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
