package com.cheng.book.java1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nuonuo
 * @create 2020-05-08 15:28
 * <p>
 * 1.   高聚合低耦合前提下，线程操作资源类
 * 2.   判断 干活 通知
 * 3.   多线程交互中必须要防止多线程的虚假唤醒， 也即（判断只用while,不能用if）
 */

class AirConditioner {

    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {//1.判断
                condition.await();
            }
            number++;//2.干活
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        WaitNotify();

    }

    private static void WaitNotify() {
        AirConditioner ac = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ac.increment();
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ac.decrement();
            }
        }, "t2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ac.increment();
            }
        }, "t3").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ac.decrement();
            }
        }, "t4").start();
    }

}
