package com.cheng.downloader;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器  接收到客户端传来的下载命令，然后进行多线程下载
 *
 * @author nuonuo
 * @create 2020-10-31 12:27
 */
public class DownLoaderServer {

    public static void main(String[] args) throws Exception {
        int port = 3000;
        Socket socket = null;
        ServerSocket serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();//获取连接
        byte[] buffs = new byte[1024];
        InputStream is = socket.getInputStream();
        int n = is.read(buffs);
        System.out.println("服务器准备返回 + " + new String(buffs, 0, n));
        OutputStream os = socket.getOutputStream();
        os.write(buffs, 0, n);

    }

}
