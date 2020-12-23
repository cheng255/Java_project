package atguigu.java2;

/**
 * 静态同步方法的锁对象为当前类的class对象
 * @author nuonuo
 * @create 2020-12-22 20:21
 */
public class SynchronizedTest {
    private static int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 19; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (SynchronizedTest.class) {
                        COUNT++;
                    }
                }
            });
        }
        threads[19] = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(COUNT);//20000
    }

    private static synchronized void increment() {
        COUNT++;
    }
}
