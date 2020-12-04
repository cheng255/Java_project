package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author nuonuo
 * @create 2020-12-01 15:28
 */
public class JDBCUtil {
    //URL
    private static final String URL = "jdbc:mysql://localhost:3306/blog?user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
    //数据库连接池
    private static final DataSource DS = new MysqlDataSource();

    static {
        ((MysqlDataSource) DS).setURL(URL);
    }

    /**
     * 获取数据库连接
     * @return 返回连接池中的一条连接
     */
    public static Connection getConnection() {
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            //抛自定义异常
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }

    /**
     * 关闭资源的操作
     * @param connection
     * @param statement
     */
    public static void closeResource(Connection connection, Statement statement) {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

