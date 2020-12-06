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
    /**
     * 按照用户id查询用户文章列表
     * @param userId
     * @return
     * @throws SQLException
     */
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

    /**
     * 根据文章id列表删除该文章
     * @param split
     * @return
     */
    public static int delete(String[] split) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            //动态拼接占位符
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");
            ps = conn.prepareStatement(sql.toString());
            //设置占位符
            for (int i = 0; i < split.length; i++) {
                ps.setInt(i + 1, Integer.parseInt(split[i]));
            }
            return ps.executeUpdate( );
        } catch (SQLException e) {
            throw new AppException("ART004", "文章删除操作出错", e);
        } finally {
            JDBCUtil.closeResource(conn,ps);
        }
    }

    /**
     * 将Article对象的信息（文章信息）加入到数据库文章表
     * @param a
     * @return
     */
    public static int insert(Article a) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into article(title, content, user_id)" +
                    " values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getUserId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART005", "新增文章操作出错", e);
        } finally {
            JDBCUtil.closeResource(conn,ps);
        }
    }



    /**
     * 根据文章id查询文章详情
     * @param id
     * @return
     */
    public static Article query(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select title, content from article where id=?";
            ps = conn.prepareStatement(sql);
            //替换占位符
            ps.setInt(1,id);
            rs = ps.executeQuery();
            //处理结果集
            Article a = null;
            while (rs.next()) {
                a = new Article();
                a.setId(id);
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
            }
            return a;
        } catch (SQLException e) {
            throw new AppException("ART006", "查询文章详情出错", e);
        } finally {
            JDBCUtil.closeResource(conn,ps,rs);
        }
    }

    /**
     * 修改文章
     * @param a
     * @return
     */
    public static int update(Article a) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update article set title=?, content=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("ART007", "修改文章信息出错", e);
        } finally {
            JDBCUtil.closeResource(conn,ps);
        }
    }
}
