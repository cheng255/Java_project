package com.cheng.java1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 内部类：
 * 静态内部类
 * 实例内部类
 * 本地内部类（基本不会使用的）
 * 匿名内部类
 * User: GAOBO
 * Date: 2020-08-07
 * Time: 9:14
 */

class MyLinkedList {
    class Node {
        public int data;
        public Node next;
    }

    public void fuc(){
        Node node = new Node();
    }

    //MyLinkedList.Node
    //MyLinkedList.Node node = myLinkedList.new Node();
}


class OuterClass {
    public int data1 = 999;
    private int data2;
    public static int data3;

    public void func() {
      //static int a = 10;
    }

    /**
     * 实例内部类：你可以把它看做是外部类的实例的成员/方法
     * 1、实例内部类当中，是不可以定义静态的成员变量的。
     *    但是，如果要非要定义，那么只有一个办法。
     *    public static final --> 此时定义的变量如果是静态的，一定是在编译时期就能
     *    确定其值的。
     * 2、如何实例化内部类对象？
     *     outerClass:外部类对象的引用
     *    OuterClass.InnerClass innerClass = outerClass.new InnerClass();
     * 3、如何访问和外部类同名的属性？
     *    面试问题：同学，实例内部类，是否有额外的开销？
     *    实例内部类当中，包含了外部类的this引用。
     *    OuterClass.this.data1 -->其实this这个东西来说，他相当于是一个静态的引用
     * 4、命名
     */
    class InnerClass {
        public int data1 = 100;
        private int data5;
        public static final int data6 = 10;

        public void func2() {
            System.out.println(this.data1);
            System.out.println(OuterClass.this.data1);
        }
    }

}

public class TestDemo2 {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func2();
    }
}
