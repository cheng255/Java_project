package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;

/**
 * @author nuonuo
 * @create 2020-12-06 16:43
 */
@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
// 抓包得到前端接口请求数据有这两个 title content 请求体格式为json
        //将json文章反序列为java对象
        ServletInputStream is = req.getInputStream();
        Article a = JSONUtil.deserialize(is, Article.class);
        //文章表的user_id外键需要用session动态获取
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        a.setUserId(user.getId());//设置用户id
        int num = ArticleDAO.insert(a);
        return null;
    }
}
