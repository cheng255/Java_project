package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-16 15:50
 */
public class StopThreadTest {
    private static volatile boolean STOP = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //执行任务
            for (int i = 0; i < 100 && !STOP; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println("t start");

        //模拟执行5秒如果t还没结束就让线程终止
        Thread.sleep(5000);
        STOP = true;
        System.out.println("t stop");
    }
}
