package com.cheng.java1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-08-07
 * Time: 9:33
 */
class OuterClass2 {
    public int data1 = 999;
    private int data2;
    public static int data6;

    /**
     * 静态内部类：静态的数据成员
     * 1、如何实例化静态内部类对象？
     *     OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2();
     * 2、静态内部类是不能够访问，外部类的实例数据成员的。
     *    非要访问怎么办？
     *    思路：只要提供给他外部类的对象的引用就好了
     *    做法就很多了？
     */
    static class InnerClass2 {
        public int data4;
        private int data1;
        public static int data6 = 88888;

        OuterClass2 out ;

        public InnerClass2(OuterClass2 o){
            this.out = o;
        }

        public void func() {
            System.out.println(data4);

            System.out.println(this.data1);
            System.out.println(this.out.data1);

            System.out.println(OuterClass2.data6);
            System.out.println(data6);

            System.out.println("静态内部类：func()");
        }
    }

}
public class TestDemo3 {
    public static void main(String[] args) {
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(new OuterClass2());
        innerClass2.func();
    }
}
