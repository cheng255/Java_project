package com.cheng.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-02-14 20:38
 */
public class TcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        Scanner scan = null;
        FileInputStream fis = null;
        try {
            //1.ip地址
            InetAddress serverIP = InetAddress.getByName("localhost");
            //2.端口
            int port = 9090;
            //3.创建socket连接
            socket = new Socket(serverIP, port);
            //4.发送消息
            os = socket.getOutputStream();
            String message = "连接成功";
            os.write(message.getBytes().length);
            os.write(message.getBytes());

            //上传文件
            fis = new FileInputStream(new File("net/beautiful.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
