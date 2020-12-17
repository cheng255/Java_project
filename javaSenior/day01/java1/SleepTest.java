package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-16 14:57
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(111);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();

    }
}
