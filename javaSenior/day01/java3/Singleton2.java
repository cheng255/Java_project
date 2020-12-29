package atguigu.java3;

/**
 * 懒汉式 线程不安全 3
 * @author nuonuo
 * @create 2020-12-23 20:57
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2() {}
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
