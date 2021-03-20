package com.atguigu.exer2;

/**
 * @author nuonuo
 * @create 2021-03-19 17:15
 */
public class synchronized1 {
    private static Object obj = new Object();

    public static void main(String[] args) {
        synchronized (obj) {
            System.out.println("hello world");
        }
    }
}
