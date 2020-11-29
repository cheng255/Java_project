package org.example.servlet;

import org.example.StatementTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author nuonuo
 * @create 2020-11-29 13:00
 */
@WebServlet("/sensitive")
public class sensitiveSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，相应编码，以及相应数据类型（为响应体设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");//设置响应体编码
        resp.setContentType("text/html");
        //解析数据
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        PrintWriter writer = resp.getWriter();//response获取io输出流

        HttpSession session = req.getSession(false);
        //现在的方式是每次访问敏感资源都获取session对象，然后验证是否为null
        //真实开发会采取filter过滤器，统一处理敏感资源验证
        if (session == null) {
            writer.println("访问失败，请登录后重试");
        } else {
            String username = (String) session.getAttribute("username");
            System.out.println(username);
            writer.println("访问成功");
        }



        writer.flush();//有缓冲的io操作，需要刷新缓冲区数据，保证发送数据
        writer.close();//关闭流资源

    }
}
