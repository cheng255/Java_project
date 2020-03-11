package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author nuonuo
 * @create 2020-03-10 21:51
 */
public class StringTest1 {

    /*

    String 与基本数据类型，包装类之间的转换

    String --> 基本数据类型，包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型，包装类 --》 String：String重载的valueOf(xxx)

     */

    @Test
    public void test1(){
        String s1 = "123";
//        int num = s1;//错
        int num = Integer.parseInt(s1);
        System.out.println(num);

        String s2 = String.valueOf(num);
        System.out.println(s2);
    }


    /*
    String 与 char[] 之间的转换



     */
    @Test
    public void test2(){
        String s1 = "abc123";
        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }

        char[] arr = {'h','e','l','l','o','w'};
        String s2 = new String(arr);
        System.out.println(s2);
    }
    /*

String 和 byte[] 之间的转换

        调用String的getBytes()

        调构造器

        编码： 字符串 --> 字节 (看得懂 --> 看不懂)
        解码： 编码的逆过程 字节 --> 字符串
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");//使用gbk的字符集
        System.out.println(Arrays.toString(gbks));

        System.out.println("******");

        String s = new String(bytes);
        System.out.println(s); // 编码集和解码集要一致


    }


}
