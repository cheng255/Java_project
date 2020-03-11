package com.atguigu.java;

import org.junit.Test;

/**
 * String的使用
 *
 * @author nuonuo
 * @create 2020-03-10 14:36
 */
public class StringTest {

    /*
    结论：
        1.常量与常量的拼接结果在常量池，且常量池中不会存在相同的常量
        2.只要其中有一个是变量，结果就在堆中
        3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */

    @Test
    public void test3(){

        String s1 = "abc";
        String s2 = "def";

        String s3 = "abc" + s2;
        String s4 = s1 + "def";
        String s5 = s1 + s2;
        String s6 = "abcdef";
        String s7 = "abc" + "def";

        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s6 == s7);//true
        System.out.println(s6 == s4);//false

        String s8 = s5.intern();//返回值得到的s8使用的常量池中已经存在的数据地址
        System.out.println(s8 == s6);//true
    }

    /*
    String：字符串，使用一对""来表示
    1.String声明为final，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的。
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value 用来存储字符串数据
    4.String:代表不可变的字符序列。简称：不可变性
        体现：1.当对一个字符串重新赋值，需要重新指定内存区域赋值
             2.当连接字符串时，也是重新指定内存区域赋值
             3.当调用String类的replace方法，也需要重新、。。。。
    5.当通过字面量的方式给一个字符串复制，此时的字符串声明在字符串常量池中
    6.字符串常量池中是不会存储相同内容的字符串的


     */


    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";

        System.out.println(s1 == s2);//true

        s1 = "bca";
        System.out.println(s1 == s2);//false

        String s3 = "abc";
        System.out.println(s3 == s2);//true
        s3 += "def";
        System.out.println(s3 == s2);//false

        String s4 = "abc";
        String s5 = s4.replace('a', 'e');
        System.out.println(s4);//abc
        System.out.println(s5);//ebc


    }

    /*
    String实例化的方式i:
    方式一：通过字面量定义的方式
    方式二：通过new + 构造器的方式


    面试题： String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？
            ans:两个：一个是对空间中new的结构，另一个是char[]对应的常量池中的数据："abc"


     */
    @Test
    public void test2(){
        //此时的数据是声明在方法区中的字符串常量池中
        String s1 = "abc";
        String s2 = "abc";
        //此时保存的地址值是数据在对空间中开辟空间以后对应的地址值
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);//true
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false

        Person p1 = new Person(12,"tom");
        Person p2 = new Person(12,"tom");

        System.out.println(p1.name == p2.name);//true,不可变性


    }

}



class Person{

    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
