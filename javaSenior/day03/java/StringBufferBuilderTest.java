package com.atguigu.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 *
 * @author nuonuo
 * @create 2020-03-11 11:52
 */
public class StringBufferBuilderTest {

    /*
    String StringBuffer StringBuilder 三者的异同？

    String: 不可变的字符序列
    StringBuffer: 可变的字符序列:线程安全，效率低
    StringBuilder: 可变的字符序列：线程不安全，效率高

    三者效率：StringBuilder > StringBuffer > String

    源码分析
    StringBuffer s1 = new StringBuffer(); 底层创建了一个长度为16的char型数组 char[16];
     */

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("hellow");
        s1.setCharAt(1,'o');
        System.out.println(s1);

    }

    /*

    StringBuffer的常用方法

    总结：增：append()
         删：delete()
         改：setCharAt(int n, char ch)  replace(int start, int end, String str)
         查：charAt(int n)
         插：insert(int offset, xxx)
         长度：length()
         遍历：for() + charAt    /   toString
         反转：reverse()

     */

    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');//添加字符
        System.out.println(s1);
//        s1.delete(2, 4);//删除字符
//        System.out.println(s1);

        s1.replace(2,4,"hellow");//替换
        System.out.println(s1);
        s1.insert(2,"hellow"); // 插入
        System.out.println(s1);
        s1.reverse(); // 反转
        System.out.println(s1);


    }




}
