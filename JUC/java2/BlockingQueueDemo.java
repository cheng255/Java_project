package com.cheng.book.java2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author nuonuo
 * @create 2020-05-09 14:55
 */




public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("a");

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());


    }
}
