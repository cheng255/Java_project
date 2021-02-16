package com.cheng.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收信息的线程
 *
 * @author nuonuo
 * @create 2021-02-15 14:32
 */
public class ChatReceive implements Runnable {
    DatagramSocket socket;//数据报连接
    private int fromPort;//自身端口
    private String fromName;//接收信息来自谁

    public ChatReceive(int fromPort, String fromName) {
        this.fromPort = fromPort;
        this.fromName = fromName;
        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //接收信息
                byte[] data = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
                socket.receive(datagramPacket);
                //将信息打印出来
                String datas = new String(datagramPacket.getData());
                System.out.println(this.fromName + ": " + datas);
                //退出
                if ("byte".equals(datas)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
