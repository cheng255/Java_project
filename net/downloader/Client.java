package com.cheng.downloader;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端   传给服务器端下载链接
 * @author nuonuo
 * @create 2020-10-31 12:28
 */
public class Client {
    public static void main(String[] args) throws Exception {
        int port = 3000;
        Socket socket = new Socket(InetAddress.getLocalHost(),port);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        os.write(s.getBytes());
        byte[] bytes = new byte[1024];
        int n = is.read(bytes);
        System.out.println("服务器反馈 + " + new String(bytes));


    }
}
