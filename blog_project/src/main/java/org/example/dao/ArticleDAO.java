package org.example.dao;

import org.example.exception.AppException;
import org.example.model.Article;
import org.example.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-12-05 14:13
 */
public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) throws SQLException {
        List<Article> articles = null;//用户文章列表
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            articles = new ArrayList<>();
            conn = JDBCUtil.getConnection();
            String sql = "select id, title from article where user_id=?";
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                Article a = new Article();
                //设置文章对象的值
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                articles.add(a);
            }
            return articles;
        } catch (SQLException e) {
            throw new AppException("ART001", "查询文章列表出错", e);
        } finally {
            JDBCUtil.closeResource(conn, ps, rs);
        }
    }
}
