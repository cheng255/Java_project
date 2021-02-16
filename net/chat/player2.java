package com.cheng.chat;

/**
 * @author nuonuo
 * @create 2021-02-15 14:40
 */
public class player2 {
    public static void main(String[] args) {
        new Thread(new ChatSend(5555, 6666, "localhost")).start();
        new Thread(new ChatReceive(9999, "小刚")).start();
    }
}
