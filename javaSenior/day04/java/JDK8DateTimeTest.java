package com.atguigu.java;

import org.junit.Test;

import java.time.*;

/**
 *
 * JDK8中日期时间的测试
 *
 * @author nuonuo
 * @create 2020-03-11 15:48
 */
public class JDK8DateTimeTest {
    /*
    LocalDate, LocalTime, LocalDateTime 的使用

     */

    @Test
    public void test1(){
        //now(): 获取当前的日期，时间，日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of() :设置指定的日期时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 3, 2, 6);
        System.out.println(localDateTime1);

        //getXxx()：获取相关属性
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfMonth());

        //with()：设置相关属性
        LocalDateTime localDateTime2 = localDateTime1.withHour(15);

        System.out.println(localDateTime1);//体现不可变性
        System.out.println(localDateTime2);

        //plus 加
        System.out.println(localDateTime2.plusHours(1));

        //minus 减
        System.out.println(localDateTime2.minusDays(1));


    }
    /*

    Instant的使用
     */
    @Test
    public void test2(){

        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); //2020-03-11T09:38:39.416Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-03-11T17:41:32.082+08:00

        //获取从1970-1-1对应的毫秒数
        long l = instant.toEpochMilli();
        System.out.println(l);

        //
        Instant instant1 = instant.ofEpochMilli(121212344L);
        System.out.println(instant1);

    }

    /*


     */


}
