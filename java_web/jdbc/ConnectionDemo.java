package com.cheng.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc创建连接
 * @author nuonuo
 * @create 2020-11-15 10:17
 */
public class ConnectionDemo {
    public static void main(String[] args) throws Exception {
        //方式一：
        //1.加载JDBC驱动程序 既将该类（Driver）加载到JVM方法去，并加载该类的静态方法块和静态属性
        Class.forName("com.mysql.jdbc.Driver");

        //2.创建数据库连接

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
        System.out.println(connection);

        //方式二：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件获取信息
        //1.读取配置文件
        InputStream is =  ConnectionDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //2.加载JDBC驱动
        Class.forName(driverClass);
        //3.创建数据库连接
        Connection connection1 = DriverManager.getConnection(url,user,password);
        System.out.println(connection1);
    }
}
