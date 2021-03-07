package com.cheng;

import org.junit.Test;

/**
 * @author nuonuo
 * @create 2021-03-07 11:11
 */
public class test1 {
    @Test
    public void test1() {

    }
    void waitForSignal() throws InterruptedException {
        Object o = new Object();
        synchronized (Thread.currentThread()) {
            o.wait();
            o.notify();
        }
    }
}
