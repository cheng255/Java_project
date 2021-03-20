package com.atguigu.exer1;

import java.util.concurrent.locks.LockSupport;

/**
 * @author nuonuo
 * @create 2021-01-17 14:51
 */
public class ABCTest1 {
    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print('a');
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print('b');
                LockSupport.unpark(t3);
            }
        });
        t3 = new Thread(() ->  {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print('c');
                System.out.println();
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
