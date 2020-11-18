package com.cheng.urlDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * 发送短信到手机
 * @author nuonuo
 * @create 2020-11-18 13:33
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        //1.准备一个URL对象
        URL url = new URL("https://itdage.com/kkb/kkbsms?key=kkb&number=18229294255&code=123456");
        //2.获取连接
        URLConnection connection = url.openConnection();
        //3.通过连接对象 获取输入流
        InputStream is = connection.getInputStream();
        //4.将输入流 装饰为一次能读取一行的 缓冲字符输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        //5.读取内容
        String s = reader.readLine();
        System.out.println(s);
        //6.关闭流
        reader.close();
    }
}
