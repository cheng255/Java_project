package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author nuonuo
 * @create 2020-11-23 21:40
 */
//注解的使用：小括号包裹多个属性  属性名=属性值，多个之间逗号间隔
    //属性名为value时可以缺省
    //Servlet定义服务：注意服务路径必须是/开头，否则tomcat启动会报错
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
     每次http请求映射到某个Servlet的资源路径，都会调用service生命周期方法
     如果请求方法没有重写，就会调用父类的doXXX(请求方法)
     （逻辑上认为没有提供该请求方法，所有返回405响应码）
     如果重写了，会将请求数据包装成一个Response响应对象
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，相应编码，以及相应数据类型（为响应体设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");//设置响应体编码
        resp.setContentType("text/html");
        //解析数据
        //req.getParameter方法获取请求数据：url和请求体，数据格式为k1=v1&k2=v2
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.printf("=================用户名（%s） 密码（%s）\n", u, p);
        if ("abc".equals(u) && "123".equals(p)) {
            //重定向：http响应状态码设置为301/302/307，响应头location
            resp.sendRedirect("home.html");
        } else if ("abc".equals(u)) {
            req.getRequestDispatcher("home.html").forward(req,resp);
        } else {
            PrintWriter writer = resp.getWriter();//response获取io输出流
            writer.println("登录失败");
            writer.println("<h3>用户名：" + u + "或密码错误</h3>");
            writer.flush();//有缓冲的io操作，需要刷新缓冲区数据，保证发送数据
            writer.close();//关闭流资源
        }

    }
}
