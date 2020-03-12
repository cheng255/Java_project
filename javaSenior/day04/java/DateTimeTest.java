package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * jdk 8 之前的日期时间和API
 *
 *  1.System类中的currentTimeMillis()
 *
 *  2.java.util.Date类 和 子类java.sql.Date
 *
 *  3.SimpleDateFormat
 *
 *  4.Calendar
 *
 *
 * @author nuonuo
 * @create 2020-03-11 14:13
 */
public class DateTimeTest {

    /*
    SimpleDateFormat的使用：SimpleDateFormat 对日期Date类的格式化和解析

    1.两个操作
    1.1 格式化： 日期 -->  字符串
    1.2 解析： 格式化的逆过程

    2.SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //使用默认构造器实例化
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        String format = sdf.format(date);//格式化
        System.out.println(format);

        //解析
        String str = "20-3-11 下午2:26";//解析需要固定格式
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //用指定的方式来格式化和解析：使用带参构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);

        //解析
        String str1 = ("2020-03-11 02:33:55");
        Date date2 = sdf1.parse(str1);
        System.out.println(date2);



    }

    /*
    练习1： 字符串"2020-03-04" 转换为java.sql.Date

     */
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        Date date = sdf.parse("2020-03-04");
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

    /*

    Calendar(abstract)日历类的使用

     */
    @Test
    public void testCalendar(){
        // 1.实例化
        //1.1 调静态方法
        //1.2 创建子类对象GregorianCalendar
        Calendar instance = Calendar.getInstance();//调静态方法
        System.out.println(instance.getClass());//class java.util.GregorianCalendar

        //常用方法
        //1.get()
        int day = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));

        //2.set() 修改当前对象信息
//        Calendar可变

        instance.set(Calendar.DAY_OF_YEAR,20);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));

        //3.add()

        //4. getTime():日历类 --> Date
        Date time = instance.getTime();
        System.out.println(time);
        //5. setTime():Date --> 日历类
        instance.setTime(time);



    }




}
