package com.crocodile.maven;
/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: Maven：管理构建Java项目的工具
 *              标准化的项目结构
 *              标准化的构建流程（编译、测试、打包、发布）
 *              依赖管理机制
 *
 *              配置setting
 *              1、本地仓库<localRepository> url </localRepository>
 *              2、aliyun 私服
 *              <mirror>
 *                  <id>alimaven</id>
 *                  <mirrorOf>central</mirrorOf>
 *                  <name>aliyun maven</name>
 *                  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
 *              </mirror>
 *
 * @Author：crocodilePole
 */
public class Client {

    public static void main(String[] args) {
        /**
         * maven常用命令： 例：mvn compile
         *
         *  compile:编译
         *  clean:清理
         *  test:测试
         *  package：打包
         *  install：安装
         *
         *  site:发布（不常用）
         *
         */
        /**
         * 生命周期：同一生命周期内，一个命令执行，则前面所有命令自动执行
         *  compile test package install
         *
         *  pre-clean  clean  post-clean
         */

    }
}
