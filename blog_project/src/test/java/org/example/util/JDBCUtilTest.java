package org.example.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author nuonuo
 * @create 2020-12-01 15:40
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
