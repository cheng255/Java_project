package com.cheng.java1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-08-07
 * Time: 9:46
 */
class OuterClass3 {
    public void func() {
        System.out.println("OuterClass3的func");
    }
}
public class TestDemo4 {

    public static void func2() {
        //方法内部的类叫做本地内部类
        class A {

        }
    }

    public static void main(String[] args) {

        new OuterClass3(){
          //类内部的内容
          public int data1;
           /* @Override
            public void func() {
                System.out.println("我重写了OuterClass3的func");
            }*/
        }.func();


        //new OuterClass3();
    }
}
