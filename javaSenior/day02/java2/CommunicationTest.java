package com.atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1，线程2 交替打印
 *
 *
 *
 * 涉及到的三个方法：
 *
 * wait():一旦执行此方法，当前线程阻塞，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒wait的一个线程，如果有多个线程被wait，就会唤醒优先级高的
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 *
 * 说明：
 * 1.这三个方法只能出现在同步代码块或同步方法中。
 * 2.这三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常
 * java.lang.IllegalMonitorStateException
 * 3.这三个方法是定义在java.lang.Object类中
 *
 *
 *
 * 面试题：sleep()和wait()的异同？
 * 1.相同点：都可与让当前线程进入阻塞状态
 * 2.不同点：① 声明的位置不同，Thread类中static sleep(); Object类中的wait();
 *          ② 调用的要求不同，sleep()可以在任何需要的场景下使用，而wait()必须使用在同步代码块或同步方法中
 *          ③ 关于是否释放同步监视器：sleep()不会释放同步监视器; wait()会释放同步监视器
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-10 9:06
 */

class Number implements Runnable{

    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        while (true) {
            synchronized (obj) {

                obj.notify();//唤醒上一个线程

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;


                    try {//使得调用wait方法的线程进入阻塞状态，并且释放锁
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
