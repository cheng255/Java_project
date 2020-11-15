package com.cheng.jdbc;

import java.sql.*;

/**
 * @author nuonuo
 * @create 2020-11-15 11:01
 */
public class StatementTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
            //3.创建操作命令对象
            statement = connection.createStatement();
            //4.执行sql  处理结果集ResultSet（查询操作）：类似List<Map<String,字段类型>>结构
            resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                System.out.printf("id=%d name=%s password=%s address=%s phone=%s\n",
                        id,name,password,address,phone);
            }
            //（一般面向对象编程会将结果集处理为一个对象或多个对象List<对象类型>）
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }

}
