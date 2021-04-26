package com.atguigu.exer2;

/**
 * 结论  Synchronized需要volatile的协助
 * @author nuonuo
 * @create 2021-04-26 10:32
 */
public class synchronizedTest1 {
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                synchronized (synchronizedTest1.class) {
                    for (int j = 0; j < 1000; j++) {
                        a++;
                    }
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(a);
    }
}
