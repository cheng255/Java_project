package atguigu.java;

/**
 * 多线程的创建， 方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作生命在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 * <p>
 * 例子：遍历100以内所有的偶数
 * @author nuonuo
 * @create 2020-03-09 12:17
 */
//1. 创建一个继承于Thread类的子类
class myThread extends Thread {
//    2. 重写Thread类的run() --> 将此线程执行的操作生命在run()中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }



}


public class ThreadTest {

    public static void main(String[] args) {
//         3. 创建Thread类的子类的对象
        myThread t1 = new myThread();

//        4. 通过此对象调用start():① 启动当前线程 ② 调用当前线程的run()
        t1.start();

        //问题一：不能通过直接调用run()的方式启动线程
//        t1.run();

        //问题二：在启动一个线程，不可以让已经start()的线程去执行。
        //需要重新创建一个线程的对象
        myThread t2 = new myThread();
        t2.start();

        //如下操作仍然实在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }


    }
}
