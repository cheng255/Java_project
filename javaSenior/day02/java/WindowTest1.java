package com.atguigu.java;

/**
 * 例子： 创建三个窗口买票，总票数为100张,使用实现Runnable接口的方式
 *  //存在线程的安全问题，待解决。
 *
 *
 *  1. 问题：卖票过程中，出现了重票和错票--> 出现了线程的安全问题
 *  2. 原因：当某个线程在操作过程中，还没结束，另一个线程也操作该共享数据
 *  3. 如何解决：当一个线程在操作共享数据时，其他数据不能参与，直到该线程操作完，其他线程
 *  才能开始操作共享数据。这种情况，即使a出现阻塞，其他线程也不能进去
 *
 *  4. java中，我们通过同步机制，来解决线程的安全问题
 *
 *      方式1：同步代码块
 *
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *
 *
 *      }
 *      说明：1.操作共享数据的代码，即为需要被同步的代码
 *           2.共享数据：多个线程共同操作的变量，比如：本题ticket
 *           3.同步监视器，俗称：锁。任何一个类的对象都可以充当锁.
 *              要求：多个线程必须要共用一把锁。
 *
 *              补充：在实现Runnable接口创建多线程的方式中，还可以考虑用this同步监视器
 *
 *      方式2：同步方法
 *
 *
 *
 *
 *
 *  5. 同步的方式：好处：解决了线程安全问题
 *
 *
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-09 15:20
 */

class Window1 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//此时的this：唯一的windows的对象 方式二：synchronized (obj)


                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

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
