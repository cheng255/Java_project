package com.atguigu.exer1;

/**
 * 三个线程   分别打印ABC   按照ABC顺序打印十次
 *
 * @author nuonuo
 * @create 2021-01-02 11:46
 */
public class ABCTest {
    private static volatile char flag = 'A';//记录本次应该打印什么字母
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintLetters('A'));
        Thread t2 = new Thread(new PrintLetters('B'));
        Thread t3 = new Thread(new PrintLetters('C'));
        t1.start();
        t2.start();
        t3.start();

    }

    static class PrintLetters implements Runnable {
        char letter;

        public PrintLetters(char letter) {
            this.letter = letter;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                synchronized (ABCTest.class) {
                    while (letter != flag) {
                        try {
                            ABCTest.class.notifyAll();
                            ABCTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(letter);
                    if (flag == 'C') {
                        flag = 'A';
                        System.out.println();
                    } else {
                        flag = (char) (flag + 1);
                    }
                    ABCTest.class.notifyAll();
                }
            }
        }
    }
}
