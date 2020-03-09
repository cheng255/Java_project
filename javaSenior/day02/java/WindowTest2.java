package com.atguigu.java;

/**
 * @author nuonuo
 * @create 2020-03-09 18:11
 */
/**
 *
 * 例子： 创建三个窗口买票，总票数为100张
 *
 * //使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-09 14:38
 */
class Window2 extends Thread{

    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {

        while (true) {


//            synchronized(obj){
                synchronized (Window2.class) {//方式二：Window2.class只会加载一次，所以也可以充当锁
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
