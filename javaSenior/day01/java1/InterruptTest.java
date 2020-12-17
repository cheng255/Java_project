package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-16 16:00
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20 && !Thread.currentThread().isInterrupted(); i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                t1.interrupt();//告诉t1线程，需要中断（设置t1线程的中断标志位为true）
                System.out.println("t1 stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t1.start();
        t2.start();

    }
}
