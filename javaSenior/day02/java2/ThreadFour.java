package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四： 使用线程池
 *
 * 使用线程池的好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *
 *      corePoolSize:核心池的大小
 *      maximumPollSize:最大线程数
 *      keepAliveTime:线程没有任务时最多保持多长时间后会终止
 *
 *
 *
 *
 * 
 * @author nuonuo
 * @create 2020-03-10 11:49
 */

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumberThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadFour {
    public static void main(String[] args) {

        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性(管理)
        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.getKeepAliveTime();


        //2.执行指定的线程操作。需要提供实现Runnable()或Callable()接口实现类的对象
        service.execute(new NumberThread1()); //适合使用于Runnable
        service.execute(new NumberThread2()); //适合使用于Runnable
//        service.submit(); //适合适用于Callable

        //3.关闭连接池
        service.shutdown();
    }
}
