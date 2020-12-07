package org.example.servlet;

import org.example.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @author nuonuo
 * @create 2020-12-07 18:43
 */

/**
 * ueditor富文本编辑器图片上传
 */
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //找到资源路径
        URL url = UEditorServlet.class.getClassLoader().getResource("config.json");
        //解码 url获取到时，都是编码后的字符串，使用时，需要先解码再使用
        String path = URLDecoder.decode(url.getPath(), "UTF-8");
        //框架提供的富文本编辑器上传功能
        MyActionEnter enter = new MyActionEnter(req, path);
        String exec = enter.exec();//执行
        PrintWriter writer = resp.getWriter();
        writer.println(exec);
        writer.flush();
        writer.close();

    }
}
