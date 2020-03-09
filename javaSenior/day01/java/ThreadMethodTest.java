package atguigu.java;

/**
 * 测试Thread中的常用方法
 * 1. start():启动当前线程，并调用当前线程中的run()
 * 2. run(): 通常我们需要重写Thread类中的此方法，将创建的线程要执行第二操作生命在此方法中
 * 3. currentThread():静态方法。返回执行当前代码的线程
 * 4. getName(): 获取当前线程的名字
 * 5. setName(): 设置当前线程的名字
 * 6. yield(): 表示释放当前cpu的执行权
 * 7. join(): 在线程a 中调用线程b 的Join(),此时线程a就进入阻塞状态，直到线程b执行完，线程a才结束阻塞
 * 8. stop(): 已过时。当执行此方法时，强制结束当前线程
 * 9. sleep(long millitime): 让当前线程睡眠指定的millitim毫秒。在指定的时间内，当前线程为阻塞状态
 * 10. isAlive(): 判断当前线程是否存活
 *
 *
 * 线程的优先级
 * 1.
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY=5;
 * MAX_PRIORITY=10;
 * 2.如何来获取和设置当前线程的优先级
 *      getPriority(): 获取线程的优先级
 *      setPriority(int p): 设置现成的优先级
 *
 *      说明： 高优先级的线程要抢占低优先级线程cpu的执行权，但只是从概率上讲
 *
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-09 13:12
 */
class aThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){

//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":"+ i);
            }

//            if (i % 20 == 0) {
//                yield();
//            }
        }

    }

    public aThread(String name){
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {
        //给分线程命名的两种方式
        aThread a1 = new aThread("Thread:1");
//        a1.setName("线程1");

        a1.setPriority(Thread.MAX_PRIORITY);
        a1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":"+ i);
            }

            if (i == 20) {

//                try {
//                    a1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

        System.out.println(a1.isAlive());


    }

}
