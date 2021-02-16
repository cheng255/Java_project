package com.cheng.chat;

/**
 * @author nuonuo
 * @create 2021-02-15 14:40
 */
public class player1 {
    public static void main(String[] args) {
        new Thread(new ChatSend(8888, 9999, "localhost")).start();
        new Thread(new ChatReceive(6666, "小明")).start();
    }
}
