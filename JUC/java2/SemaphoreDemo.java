package com.cheng.book.java2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author nuonuo
 * @create 2020-05-09 12:28
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);


        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " 离开了车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
