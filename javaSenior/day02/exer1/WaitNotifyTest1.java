package com.atguigu.exer1;

/**
 * @author nuonuo
 * @create 2021-01-31 15:11
 */
public class WaitNotifyTest1 {
    public static void main(String[] args) {
        try {
            waitForsingal();//2调用会报IllegalMonitorStateException  wait必须要锁对象调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitForsingal() throws InterruptedException {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            obj.wait();//1首先汇报InterruptedException  wait是直接当前线程等待，并释放锁资源
            obj.notify();
        }
    }
}
