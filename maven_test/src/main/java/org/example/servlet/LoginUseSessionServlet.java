package org.example.servlet;

/**
 * @author nuonuo
 * @create 2020-11-29 12:44
 */

import org.example.StatementTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/loginUseSession")
public class LoginUseSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，相应编码，以及相应数据类型（为响应体设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");//设置响应体编码
        resp.setContentType("application/json");
        //解析数据
        //req.getParameter方法获取请求数据：url和请求体，数据格式为k1=v1&k2=v2
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        PrintWriter writer = resp.getWriter();//response获取io输出流
        /**
         * 这里使用数据库jdbc操作来判断账号密码
         */
        String sql = "select username, password from user where username=? and password=?";
        boolean b = StatementTest.executeQuery(sql, u,p);
        if (b) {
            writer.println("{\"success\": true}");
            HttpSession session = req.getSession();//创建一个session 无参默认是true，表示无论如何都要创建
            session.setAttribute("username",u);
            session.setAttribute("password", p);
        } else {
            writer.println("{\"success\": false}");
        }
        writer.flush();//有缓冲的io操作，需要刷新缓冲区数据，保证发送数据
        writer.close();//关闭流资源

    }
}
