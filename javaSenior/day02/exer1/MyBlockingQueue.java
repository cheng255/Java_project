package com.atguigu.exer1;

/**
 * 线程安全的阻塞式队列
 *
 * @author nuonuo
 * @create 2021-01-02 17:11
 */
public class MyBlockingQueue <T>{
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>();
        for (int i = 0; i < 5; i++) {
            new Thread(()-> {
                for (int j = 0; j < 1000; j++) {
                    try {
                        myBlockingQueue.add(j);
                        System.out.println(Thread.currentThread().getName() + "将" + j + "加入队列,当前元素有" + myBlockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("hahahahahhaha");
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Integer poll = myBlockingQueue.poll();
                        System.out.println(Thread.currentThread().getName() + "将" + poll + "取出队列,当前元素有" + myBlockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("hahahahahhaha");
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
//        myBlockingQueue.add(1);
//        myBlockingQueue.add(2);
//        myBlockingQueue.add(3);
//        System.out.println(myBlockingQueue.poll());
//        System.out.println(myBlockingQueue.poll());
//        System.out.println(myBlockingQueue.poll());
    }

    private static int CAPACITY = 1000;
    private volatile Object[] data;
    private volatile int first;
    private volatile int end;
    private volatile int size;

    public MyBlockingQueue() {
        data = new Object[CAPACITY];
        first = 0;
        end = -1;
        size = 0;
    }

    /**
     * 入队列操作
     */
    public synchronized void add(T val) throws InterruptedException{
        while (size >= CAPACITY) {
//            throw new RuntimeException("容量已满，添加元素错误");
            this.wait();
        }
        end = (end + 1) % CAPACITY;
        data[end] = val;
        size++;
        notifyAll();
    }


    /**
     * 出队列操作
     */
    public synchronized T poll() throws InterruptedException{
        while (size <= 0) {
//            throw new RuntimeException("队列已空，出元素错误");
            this.wait();
        }
        int pollIndex = first;
        first = (first + 1) % CAPACITY;
        size--;
        notifyAll();
        return (T) data[pollIndex];
    }

    public synchronized int size() {
        return size;
    }
}
