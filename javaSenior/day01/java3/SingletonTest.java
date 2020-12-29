package atguigu.java3;

/**
 * @author nuonuo
 * @create 2020-12-24 13:32
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton5 instance = Singleton5.INSTANCE;
        Singleton5 instance1 = Singleton5.INSTANCE;
        System.out.println(instance == instance1);
    }
}
