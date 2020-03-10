package com.atguigu.java2;

/**
 * 线程通信的应用：
 *
 * 经典例题：生产者与消费者问题
 *
 *  生产者将产品交给店员，而消费者从店员购买产品：
 *  店员一次只能维护固定数量的产品（比如20）
 *   如果，产品没有了，就通知生产者生产产品，消费者等待；
 *   如果，产品有剩余，生产者等待生产，消费者买走产品！
 * @author nuonuo
 * @create 2020-03-10 10:29
 */

class Clerk{

    private int produceCount = 0;

    public synchronized void produceProduct() {//生产
        if (produceCount < 20) {
            produceCount++;
            System.out.println(Thread.currentThread().getName() + ": 开始生产第" + produceCount + "个产品");

            notify();

        } else{//等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void consumeProduct() {//消费

        if (produceCount > 0) {
            System.out.println(Thread.currentThread().getName() + ": 开始消费第"+ produceCount + "个产品");
            produceCount--;

            notify();

        } else{//等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产产品。。。。");

        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }

}

class Consumer extends Thread{//消费者

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费产品。。。。。");

        while (true) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        c1.setName("消费者1");
        c2.setName("消费者2");

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        c1.start();
        c2.start();
        p1.start();
    }
}
