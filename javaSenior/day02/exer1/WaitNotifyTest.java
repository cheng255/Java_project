package com.atguigu.exer1;

/**
 * 十个生产者  20个消费者   最大库存为100
 *
 * @author nuonuo
 * @create 2020-12-30 13:38
 */
public class WaitNotifyTest {
    private static final int PRODUCER_NUMBER = 10;
    private static final int CONSUMER_NUMBER = 20;
    private static int count = 0;//面包店当前面包数
    private static final int PRODUCER_TIME = 3;//每天可用生产次数
    private static final int PRODUCER_frequency = 3;//每次生产的面包数
    private static final int BREAK_SUM = PRODUCER_TIME * PRODUCER_frequency * PRODUCER_NUMBER;//每天供应的所有面包数


    private static volatile int bs = 0;

    public static void main(String[] args) {
        Thread[] pros = new Thread[PRODUCER_NUMBER];
        Thread[] cons = new Thread[CONSUMER_NUMBER];
        for (int i = 0; i < PRODUCER_NUMBER; i++) pros[i] = new Thread(new Producer(PRODUCER_TIME), "生产者" + i);
        for (int i = 0; i < CONSUMER_NUMBER; i++) cons[i] = new Thread(new Consumer(), "消费者" + i);

        for (int i = 0; i < PRODUCER_NUMBER; i++) pros[i].start();
        for (int i = 0; i < CONSUMER_NUMBER; i++) cons[i].start();

    }

    //生产者
    static class Producer implements Runnable {
        private int time;//生产者可以生产的次数
        public Producer(int time) {
            this.time = time;
        }
        @Override
        public void run() {
            while (true) {
                try {
                        synchronized (WaitNotifyTest.class) {
                            if (time == 0) {
                                //生产者生产次数用完
                                break;
                            }
                            if (count >= 15) {
                                WaitNotifyTest.class.wait();
                            } else {
                                time--;
                                Thread.sleep(100);
                                count += PRODUCER_frequency;
                                System.out.println(Thread.currentThread().getName() + "生产了一个面包,剩余" + count);
                                WaitNotifyTest.class.notifyAll();
                            }

                        }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者
    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                        synchronized (WaitNotifyTest.class) {
                            if (bs >= BREAK_SUM) {
                                break;
                            }
                            if (count <= 0) {
                                WaitNotifyTest.class.wait();
                            } else {
                                Thread.sleep(100);
                                count--;
                                bs++;
//                                System.out.println(bs);
                                System.out.println(Thread.currentThread().getName() + "购买了一个面包，剩余" + count);
                                WaitNotifyTest.class.notifyAll();
                            }
                        }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
