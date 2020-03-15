package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 1.泛型在继承方面的体现
 *
 *
 * 2.通配符的使用:通配符：？
 *          类A时类B的子类，G<A>和G<B>是没有关系的，二者共同的父类：G<?>
 *
 * @author nuonuo
 * @create 2020-03-15 13:48
 */
public class GenericTest1 {
    //泛型在继承方面的体现
    @Test
    public void test1(){
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;//编译不通过

    }
    //通配符的使用

//    list<?> 不能向其内部添加数据，除了null
//            允许读取数据，读取的数据类型为Object

    @Test
    public void test2(){
        List<Object> list1 = new ArrayList<>();
        list1.add(123);
        List<String> list2 = null;

        List<?> list = null;
        list = list1;

        print(list1);

    //添加
//        list.add(12);
    //读取
        Object o = list.get(0);
        System.out.println(o);
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

    }

    /*
    3.有限制条件的通配符

    ? extends Person: 相当于 <=
    ? super Person:  相当于 >=
     */


}
