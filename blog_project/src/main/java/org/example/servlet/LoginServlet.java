package org.example.servlet;

import org.example.exception.AppException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        if ("abc".equals(username)) {//模拟用户名密码校验
            //登录成功 重定向
            return null;
        }  else {
            throw new AppException("U400","用户名或者密码错误");
        }
    }
}
