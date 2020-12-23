package atguigu.java2;

/**
 * 有一个教室，有50个座位，同时有三个老师安排同学的座位，
 * 每个老师安排一百个同学  直到座位安排满
 * @author nuonuo
 * @create 2020-12-22 21:09
 */
class Classroom implements Runnable {
    private static int COUNT = 50;
    @Override
    public void run() {
        //安排座位
        seat();
    }
    private void seat() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                if (COUNT > 0) {
                    //还有座位
                    System.out.println(Thread.currentThread().getName() + "安排同学" + i + "坐在 "
                            + (51 - COUNT) + " 座位上");
                    COUNT--;
                }
            }
            try {//TODO 为什么加sleep 为什么sleep加在外面
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class SynchronizedTest2 {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        Thread t1 = new Thread(classroom, "teacher1");
        Thread t2 = new Thread(classroom, "teacher2");
        Thread t3 = new Thread(classroom, "teacher3");
        t1.start();
        t2.start();
        t3.start();
    }


}
