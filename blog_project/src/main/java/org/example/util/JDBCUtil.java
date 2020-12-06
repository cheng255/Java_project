package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
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

    /**
     * 工具类提供数据jdbc操作
     * 存在的不足: 1.static代码块出现错误，NoClassDefFoundError 表示类可以找到，但类加载失败，无法运行
     *            2.之后可以采取双重校验锁的单例模式来创建DataSource
     *            3.工具类设计上不是最优，数据库框架ORM矿建Mybatis, 都是模板模式设计的
     *
     */
    static {
        ((MysqlDataSource) DS).setURL(URL);
    }

    /**
     * 获取数据库连接
     *
     * @return 返回连接池中的一条连接
     */
    public static Connection getConnection() {
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            //抛自定义异常
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    /**
     * 关闭资源的操作
     *
     * @param connection
     * @param statement
     */
    public static void closeResource(Connection connection, Statement statement) {
        closeResource(connection, statement, null);
    }

    /**
     * 关闭资源的操作
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new AppException("JDBC001", "数据库释放资源错误", e);
        }
    }
}

