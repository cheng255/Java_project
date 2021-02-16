package com.cheng.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 发送信息的线程
 * @author nuonuo
 * @create 2021-02-15 14:19
 */
public class ChatSend implements Runnable{
    private int fromPort;//自身端口
    private int toPort;//去向地址
    private String toIP;
    DatagramSocket socket;//数据报连接
    BufferedReader br;

    public ChatSend(int fromPort, int toPort, String toIP) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIP = toIP;
        try {
            socket = new DatagramSocket(fromPort);
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = br.readLine();
                byte[] data = msg.getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName(toIP), toPort);
                socket.send(dp);

                //判断退出
                if ("bye".equals(msg)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭资源
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();

    }
}
