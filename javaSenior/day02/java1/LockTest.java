package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 -----JDK5.0新增
 *
 * 1. 面试题：synchronized 和 lock的异同
 * 同：都可以解决线程安全问题
 * 异：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *     lock需要手动的启动同步lock()和同步结束也需要手动的实现unlock()
 *
 * 2.优先使用顺序：
 * lock -> 同步代码块 -> 同步方法
 *
 * 3. 面试题：如何解决线程安全问题？有几种方法
 *
 * @author nuonuo
 * @create 2020-03-09 20:24
 */

class Window implements Runnable{

    private int ticket = 100;

    // 1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            try {

                // 2.调用锁定方法lock()
                if (ticket > 0) {
                    lock.lock();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            } finally {
               // 3.调用解锁方法：unlock()
                lock.unlock();
            }
        }

    }
}
public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
