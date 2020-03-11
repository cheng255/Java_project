package com.atguigu.java;

import org.junit.Test;

/**
 * @author nuonuo
 * @create 2020-03-10 21:00
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "Hellow";

        System.out.println(s1.length());
        System.out.println(s1.charAt(1));//获取单个字符
        System.out.println(s1.charAt(5));
//        System.out.println(s1.charAt(6));

        System.out.println(s1.isEmpty());//false

        String s2 = s1.toLowerCase();//把所有字符变小写
        String s3 = s1.toUpperCase();//把所有字符变大写
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1);//也体现不可变性

        String s4 = "   hel lo w  ";
        String s5 = s4.trim();//去除收尾空格
        System.out.println(s4);
        System.out.println(s5);


    }

    @Test
    public void test2(){
        String s1 = "HellewWord";
        String s2 = "hellewword";
        System.out.println(s1.equals(s2));//比较字符串
        System.out.println(s1.equalsIgnoreCase(s2));//不区分大小写比较字符串

        String s3 = s1.concat("hahaha");//连接 等价于 +
        System.out.println(s3);

        String s4 = "abc";
        String s5 = "abcd";
        System.out.println(s4.compareTo(s5));//涉及到字符串排序

        String s6 = "我爱共产党";
        String s7 = s6.substring(2);//两个参数的时候beginIndex,  endIndex  区间左闭右开
        System.out.println(s7);
    }

    @Test
    public void test3(){
        String s1 = "hellowworld";
        boolean b1 = s1.endsWith("ld");//以什么结尾
        System.out.println(b1);

        boolean b2 = s1.startsWith("ll",2);//以什么开始，并可以某个索引开始
        System.out.println(b2);

        String s2 = "wo";
        System.out.println(s1.contains(s2));

        System.out.println(s1.indexOf("lo"));//找该字符串首次在字符串中出现的索引位置

        System.out.println(s1.indexOf("lo",4));

        System.out.println(s1.lastIndexOf("lo"));//从后往前找，返回索引还是从前往后的索引
    }

    @Test
    public void test4(){
        String s1 = "中国人";
        String s2 = s1.replace('中', '美');
        String s3 = s1.replace("中国", "日本");
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "12345";
        boolean matches = s4.matches("\\d+");//匹配：\\d+表示全为数字
        System.out.println(matches);
    }

}
