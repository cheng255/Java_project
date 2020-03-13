package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * jdk5.0 新增了foreach循环，用于遍历集合，数组
 *
 *
 * @author nuonuo
 * @create 2020-03-12 21:02
 */
public class forTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("ABB");
        coll.add(new String("ABC"));
        coll.add(123);//自动装箱
        coll.add(new Date());
        coll.add(new Person("张三",18));


        //for( 集合元素的类型 局部变量 ：集合对象)
        for(Object obj : coll){
            System.out.println(obj);
        }

    }

    @Test
    public void test2(){
        int[][] arr = new int[][]{{1,2,3,4},{1,2,3,4},{4,5,6,7,8}};
        for(int[] i : arr){
            for (int j : i){
                System.out.println(j);
            }
        }
    }


}
