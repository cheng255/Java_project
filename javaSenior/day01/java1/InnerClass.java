package atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-12-15 14:34
 */
public class InnerClass {
    public static void main(String[] args) {
        new A() {
            @Override
            public void y() {
                System.out.println("y重写方法调用");
            }
        }.y();
    }
}

class A {
    public void y() {
        System.out.println("y方法调用");
    }
}
