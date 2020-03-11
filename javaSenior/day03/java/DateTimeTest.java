package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDk 8 之前的时间和日期的API测试
 *
 * @author nuonuo
 * @create 2020-03-11 12:36
 */
public class DateTimeTest {

    /*
    1.System类中的currentTimeMillis()
     */
    @Test
    public void test1(){

        long l = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间毫秒为单位的时间差
        //称为时间戳
        System.out.println(l);
    }

    /*
    2.java.util.Date类


       ① 两个构造器的使用

       ② 两个方法的使用
       toString(): 显示当前的年 月 日 时 分 秒

       getTime(): 获取当前Date对象对应的毫秒数


    3.java.sql.Date类对应着数据库中的日期类型的变量



     */
    @Test
    public void test2(){

        //构造器1：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        System.out.println(date1.getTime());

        //构造器2：创建指定毫秒数的Date对象
        Date date2 = new Date(12112393193L);
        System.out.println(date2);

        Date date3 = new java.sql.Date(123123123L);
        System.out.println(date3);

        //如何将java.util.Date 对象转化为java.sql.Date
        //情况一：强转

        //情况二：
        Date date4 = new Date();
        Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);


    }
}
