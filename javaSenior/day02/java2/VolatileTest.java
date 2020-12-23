package atguigu.java2;

/**
 * @author nuonuo
 * @create 2020-12-23 20:43
 */
public class VolatileTest {
    //1.保证可见性，2.禁止指令重排序 建立内存屏障
    //3.不保证原子性
    //常见使用场景：
    //一般读写分离的操作，提供性能
    //（1）写操作不依赖共享变量，赋值是一个常量
    // （2） 作用在读，写依赖其他手段（加锁）
    public static void main(String[] args) {

    }
}
