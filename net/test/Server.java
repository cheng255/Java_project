package com.cheng.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 作为 TCP 的被动连接方，需要监听一个固定的端口（选择 8080）
        // 端口是随意选择的，只要该端口目前没有被占用

        // 下面的语句完成后，TCP 端口就完成了 LISTEN
        ServerSocket serverSocket = new ServerSocket(8080);

        // 三次握手发生在 accept 的调用过程中
        // 我们通过 socket 向 OS 要已经建立的 TCP 连接
        // 1. 目前有已经建立好的连接，OS 立即返回
        // 2. 否则，会一直等，直到有 client 过来建立好连接
        Socket socket = serverSocket.accept();
        // socket 代表已经建立好的一条 TCP 连接（三次握手结束了）
        System.out.println("有一条 TCP 连接已建立");

        // socket 关联的 TCP 连接已经建立（ESTABLISHED）
        // 我们作为应用层，正常的进行数据通信即可

        // 我们可以通过 inputStream，读取 client 发送过来的应用层数据
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String line = scanner.nextLine();       // 先读取客户端发来的消息
        System.out.println(line);

        // 我们可以通过将数据写入 outputStream，经过OS内部的TCP机制，将数据发送给 client
        OutputStream outputStream = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.printf("今天的项目很难\r\n");
        printWriter.flush();    // 只要进行了刷新(flush)操作，才能把数据真正写入

        // 触发这个 socket 关联的 TCP 连接的四次挥手
        socket.close();
        // 四次挥手结束
    }
}
