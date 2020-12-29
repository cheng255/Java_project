package atguigu.java3;

/**
 * 饿汉式   两种  1 2
 * @author nuonuo
 * @create 2020-12-23 20:53
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();//1

    //2
//    private static Singleton1 instance = null;
//    static {
//        instance = new Singleton1();
//    }

    private Singleton1() {}
    public static Singleton1 getInstance() {
        return instance;
    }
}
