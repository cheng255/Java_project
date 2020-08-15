package com.cheng.book.java2;

import java.util.concurrent.CountDownLatch;

/**
 * @author nuonuo
 * @create 2020-05-09 12:08
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println("同学" + Thread.currentThread().getName() + "走出教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println("班长关门");

    }
}
