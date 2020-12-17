package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-15 15:13
 */
public class ThreadLock2 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 20; i1++) {
                    System.out.println(i1 + Thread.currentThread().getName());
                }
            }).start();
        }

        new Thread(() -> {
            System.out.println("fuck");
        }, "t1").start();
    }
}
