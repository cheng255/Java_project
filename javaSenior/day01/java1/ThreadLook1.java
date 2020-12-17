package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-15 14:45
 */
public class ThreadLook1 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }.start();
    }
}
