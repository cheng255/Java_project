package com.cheng.book.java2;

import java.util.concurrent.*;

/**
 * @author nuonuo
 * @create 2020-05-22 8:26
 */
public class MyThreadPoolDemo1 {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {

            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t办理业务");
            });
        }
    }
}
