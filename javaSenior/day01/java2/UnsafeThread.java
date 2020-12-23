package atguigu.java2;

/**
 * 加锁的关键是需要对同一个对象加锁
 * @author nuonuo
 * @create 2020-12-21 19:26
 */
public class UnsafeThread {
    private static int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (UnsafeThread.class) {
                        COUNT++;
                    }
                }
            });

        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(COUNT);
    }
}
