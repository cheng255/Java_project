package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的使用：
 * 1. jdk 5.0 新增的特性
 *
 * 2. 在集合中使用泛型：
 *      总结：
 *      ① 集合接口或者集合类在jdk5.0时都修改为带泛型的结构
 *      ② 在实例化集合类时，可以致命具体的泛型类型
 *      ③ 注意点： 泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，用包装类替换
 *      ④ 默认泛型类型时java.lang.Object类型
 *
 *
 * 3. 自定义泛型结构：泛型类，泛型接口； 泛型方法
 *
 *      3.1 关于自定义类和结构
 *      静态方法中不能使用类的泛型
 *      异常类不能是泛型类
 *
 *
 * @author nuonuo
 * @create 2020-03-15 12:38
 */
public class GenericTest {
    //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
    //要求： 如果大家定义了类时带泛型的，建议在实例化时要指明类的泛型

    @Test
    public void test1(){
//        Order order = new Order();
//        order.setOrderT(123);
//        order.setOrderT("asd");

        //建议：
        Order<String> order = new Order<>("orderAA", 13, "AA");
        order.setOrderT("BB");
        System.out.println(order.getOrderT());

        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);

        SubOrder1<String> stringSubOrder1 = new SubOrder1<>();

    }
    @Test
    public void test2(){
        ArrayList<String> list = null;
        ArrayList<Integer> list1 = new ArrayList<>();

        //泛型不同的引用不能相互赋值
//        list = list1;

    }
    //测试泛型方法
    @Test
    public void test3(){

        Order<String> order = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        //泛型方法在调用时指明泛型类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }

}
