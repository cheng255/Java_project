package com.cheng;

import org.junit.Test;

import java.util.HashMap;

/**
 * 复习时根据ctrl+f  搜索数字题号
 * @author nuonuo
 * @create 2020-11-23 23:34
 */
class A {
    public static void a() {
        System.out.println(1);
    }
}
class B extends A {
    B() {
        super();// 2.super在子类构造方法中必须载第一行，否则编译报错
//        this(1);//this()调用也必须在构造方法中的第一行，否则编译报错
        //所以this() 和 super() 不能出现在同一隔构造函数中
        System.out.println(1);
    }
    B(int a) {
        System.out.println(2);
    }
}
//class C {
//    public int c () {
//        static int i;//3.方法内部不能定义static变量
//        i++;
//        return i;
//    }
//}
abstract class D {
//    abstract private void d();//abstract修饰
    /**
     * 5.
     * 对于abstract方法只允许声明，不允许实现
     * 并且不允许使用final和abstract同时修饰一个方法或者类，
     * 也不允许使用static修饰abstract方法。也就是说，abstract方法只能是实例方法，不能是类方法。
     * abstract类不能使用new运算符创建对象
     *
     *
     * 重点常考！：final和abstract，private和abstract，static和abstract，
     * 这些是不能放在一起的修饰符，因为abstract修饰的方法是必须在其子类中实现（覆盖），
     * 才能以多态方式调用，以上修饰符在修饰方法时期子类都覆盖不了这个方法，final是不可以覆盖，
     * private是不能够继承到子类，所以也就不能覆盖，static是可以覆盖的，
     * 但是在调用时会调用编译时类型的方法，因为调用的是父类的方法，而父类的方法又是抽象的方法，
     * 又不能够调用，所以上的修饰符不能放在一起。
     */
}
public class test {
    static int i;
    @Test
    public void test1() {
        System.out.println(i);
//        new Serializable() 可序列化  1.
        System.out.println(Math.round(-11.5));
    }
    @Test
    public void test2() {
        A a1 = null;
        a1.a();//4.可以编译且运行通过，证明这是在编译阶段就看成A了,但不建议
        System.out.println("123" == "12" + "3");
        String s2 = "12" + new String("3");
        String s1 = "123";
        System.out.println(s1 == s2);

        //6.
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(null, null));
    }

    @Test
    public void test3() {
        class A {
            A (String a) {

            }
        }
        class B extends A {

            B(String a) {
                super(a);//7.在父类没有空参构造方法时，子类要显示调用父类的构造方法
            }
        }

        //8. thread 类的t.join 方法会结束当前的线程对cpu的控制，然后将t占据cpu控制，直到t线程执行完
//        new ConcurrentHashMap<>()
        String s;
//        System.out.println("s=" + s);//9.没有初始化

        int a = 5 >> 2;
        System.out.println(a);
        int b = a >>> 2;
        System.out.println(b);
//        new StringBuilder()
    }
    @Test
    public void test4() {
        byte[] src = new byte[0],dst;
//        dst = new String(src,"GBC").getBytes("UTF-8");
        //10.foreach 用break跳出循环
        int[] arr = new int[7];

        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        b3 = (byte) (b1 + b2); //11.+运算时，byte还是按int计算，实际上byte也是按int存储


        String s1 = "abc";
        String s2 = "a" + new String("bc");
        System.err.println(s1 == s2); //false
    }

    @Test
    public void test5() {
//        test01.s;//12.在接口中的变量都默认是public static final的全局常量，可以省略前述的修饰词，可以被实现了接口的类直接访问并调用

//        Arrays.copyOf()
//        clone()
    }
}
