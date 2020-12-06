package org.example.servlet;

import org.example.dao.LoginDAO;
import org.example.exception.AppException;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author nuonuo
 * @create 2020-12-01 15:25
 */
@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = LoginDAO.query(username);
        if (user == null) {
            throw new AppException("LOG002", "用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new AppException("LOG003", "用户名或密码错误");
        }
        //登录成功，创建session会话
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        return null;

//        if ("abc".equals(username)) {//模拟用户名密码校验
//            //登录成功 重定向
//            return null;
//        }  else {
//            throw new AppException("U400","用户名或者密码错误");
//        }
    }
}
