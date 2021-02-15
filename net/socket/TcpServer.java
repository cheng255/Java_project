package com.cheng.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author nuonuo
 * @create 2021-02-14 20:38
 */
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;
        try {
            //1.服务器地址 要监控的端口号
            serverSocket = new ServerSocket(9090);
            //2，接收到客户端连接
            while (true) {
                socket = serverSocket.accept();
                //3.读取信息
                is = socket.getInputStream();
                //4.管道流！
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
//                while ((len = is.read(buffer)) != -1) {
//                    baos.write(buffer, 0, len);
//                }
//                System.out.println(baos.toString());
                len = is.read();
                is.read(buffer, 0, len);
                baos.write(buffer);
                System.out.println(baos.toString());
                //接收文件
                fos = new FileOutputStream(new File("net/receive.jpg"));
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
