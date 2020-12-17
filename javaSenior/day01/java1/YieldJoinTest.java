package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-16 15:15
 */
public class YieldJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int n = i;
            Thread t = new Thread(() -> {
                System.out.println(n);//内部类使用外部变量只能是final
            });
            threads[i] = t;
        }
//        while (Thread.activeCount() > 1) {
//            Thread.yield();//实际开发不会这么写
//        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("ok");
    }
}
