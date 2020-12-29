package atguigu.java3;

/**
 * 懒汉式线程安全  双重校验锁 4
 * @author nuonuo
 * @create 2020-12-23 21:01
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;
    private Singleton3(){}
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
