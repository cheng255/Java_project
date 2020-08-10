package com.cheng.book.java1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 精确通知顺序访问
 * <p>
 * 四个线程依次打印固定次数的数字
 *
 * @author nuonuo
 * @create 2020-05-08 16:32
 * <p>
 * 1.   高聚合低耦合前提下，线程操作资源类
 * 2.   判断 干活 通知
 * 3.   多线程交互中必须要防止多线程的虚假唤醒， 也即（判断只用while,不能用if）
 * 4.   标志位
 */

class ShareResourse {

    private int number = 1;//1:A 2:B 3:C
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print1(int k) {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < k; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2(int k) {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < k; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print3(int k) {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 0; i < k; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


public class Lock8 {

    public static void main(String[] args) {

        ShareResourse resourse = new ShareResourse();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourse.print1(5);
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourse.print2(10);
            }
        }, "t2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourse.print3(15);
            }
        }, "t3").start();

    }
}
