package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.AppException;
import org.example.model.Article;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-12-05 14:13
 */
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //获取session，如果没有就返回null
        HttpSession session = req.getSession(false);
        if (session == null) {
            throw new AppException("ART002", "用户未登录,不允许访问");
        }
        //获取登录时创建的session保存的用户信息
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException("ART003", "会话异常，请重新登录");
        }
        //到这表示 用户已经登录,并且session保存了用户信息
        //根据用户id获取到该用户博客信息
        List<Article> articles = ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
