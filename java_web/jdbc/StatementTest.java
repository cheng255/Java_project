package com.cheng.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-11-15 11:01
 */
public class StatementTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> userList = null;
        try {
            //1.加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
            //3.创建操作命令对象
            statement = connection.createStatement();
            //4.执行sql  处理结果集ResultSet（查询操作）：类似List<Map<String,字段类型>>结构
            //这里使用对象列表来处理
            userList = new ArrayList<>();
            resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                User user = new User(id, name, password, address, phone);
                userList.add(user);
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
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
    private static class User {
        private int id;
        private String name;
        private String password;
        private String address;
        private String phone;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        public User() {
        }

        public User(int id, String name, String password, String address, String phone) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.address = address;
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

}
