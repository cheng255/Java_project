package com.cheng.book.java1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目： 三个售票员  卖出  30 张票
 * <p>
 * 如何编出企业级的多线程代码
 * <p>
 * 1.在高内聚低耦合的前提下  线程    操作   资源类
 * <p>
 * 1.1 先创建一个资源类
 *
 * @author nuonuo
 * @create 2020-05-07 10:44
 */

//票的资源类
class ticket {
    Lock lock = new ReentrantLock();
    private int num = 30;

    public void sale() {
        lock.lock();
        try {
            if(num > 0){
                System.out.println(Thread.currentThread().getName() +
                        "\t卖出第：" + (num--) + "\t 还剩下 ：" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class SaleTicketDemo01 {

    public static void main(String[] args) {

        ticket ticket = new ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "t3").start();

    }

}

