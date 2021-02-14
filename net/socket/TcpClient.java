package com.cheng.socket;

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
        try {
            //1.ip地址
            InetAddress serverIP = InetAddress.getByName("localhost");
            //2.端口
            int port = 9090;
            //3.创建socket连接
            socket = new Socket(serverIP, port);
            //发送消息
            os = socket.getOutputStream();
            scan = new Scanner(System.in);
            os.write("连接成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
