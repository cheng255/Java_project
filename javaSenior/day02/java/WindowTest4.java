package com.atguigu.java;

/**
 *
 * 使用同步方法来解决实现Runnable接口的线程安全问题,还是需要加static
 *
 * @author nuonuo
 * @create 2020-03-09 18:56
 */
class Window4 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {

        while (true) {

            show();
        }
    }

    private static synchronized void show() { // 现在的同步监视器：Window4.class
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }

    }

}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
