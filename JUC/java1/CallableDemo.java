package com.cheng.book.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author nuonuo
 * @create 2020-05-09 11:24
 */


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hahha");
                return "helloCallable";
            }
        });
        new Thread(task,"t1").start();

        System.out.println(task.get());



    }

}
