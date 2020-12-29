package atguigu.java3;

/**
 * 静态内部类 5
 * @author nuonuo
 * @create 2020-12-23 21:05
 */
public class Singleton4 {

    private Singleton4(){}
    private static class SingletonInstance {
        private static final Singleton4 instance = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return SingletonInstance.instance;
    }

}
