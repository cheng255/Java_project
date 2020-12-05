package org.example.dao;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author nuonuo
 * @create 2020-12-05 12:48
 */
public class LoginDAO {
    /**
     * 做用户名验证操作
     * @param username
     * @return
     * @throws SQLException
     */
    public static User query(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;//如果找到结果集只有一条数据
        User user = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id, username, password, nickname, sex," +
                    " birthday, head from user where username=?";
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1,username);
            rs = ps.executeQuery();
            user = null;
            while (rs.next()) {
                user = new User();//将user信息填充并返回
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setSex(rs.getBoolean("sex"));
                //java中一般使用java.util.Date(年月日时分秒)
                //rs.getDate() 返回值时java.sql.Date（时分秒）
                //rs.getTimestamp() 返回值设计java.sql.Timestamp(年月日时分秒)
                java.sql.Date birthday = rs.getDate("birthday");
                if (birthday != null) {
                    user.setBirthday(new Date(birthday.getTime()));
                }
                user.setHead(rs.getString("head"));
            }
            return user;
        } catch (SQLException e) {
            throw new AppException("JDBC002", "查询操作出错", e);
        } finally {
            JDBCUtil.closeResource(conn,ps,rs);
        }
    }
}
