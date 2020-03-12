package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 多个对象进行排序，需要使用两个接口中的任意一个 Comparable 或 Comparator
 *
 * Comparable接口的使用-自然排序
 *
 * Comparator定制排序
 *
 *
 *
 * 总结：给一个类实现Comparable接口,可长期使用Arrays.sort排序
 *      Comparator接口重写Compare()用于临时
 *
 *
 * @author nuonuo
 * @create 2020-03-11 18:16
 */
public class CompareTest {
    /*
    Comparable接口的使用举例
    1. 像String,包装类等实现了Comparable接口，重写了compareTO()方法，给出了比较两个对象大小的方法
    2重写CompareTo的规则!!!
    如果当前对象this大于形参对象obj，则返回正整数
    如果当前对象this小于形参对象obj，则返回负整数
    如果当前对象this等于形参对象obj，则返回0

    3.对于自定义类，如果需要排序，我们需要让自定义类实现Comparable接口，并重写compareTO()


     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","BB","KK","GG","JJ","DD","CC"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));


    }

    @Test
    public void test2(){

        Goods[] arr = new Goods[5];
        arr[0] = new Goods(1998, "联想");
        arr[1] = new Goods(9022, "华为");
        arr[2] = new Goods(1999, "小米");
        arr[3] = new Goods(5000, "苹果");
        arr[4] = new Goods(5000, "小米");

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口：定制排序


    重写compare(Object o1, Object o2)方法，比较o1和o2的大小
    如果o1大于o2，则返回正整数
    如果o1小于o2，则返回负整数
    如果o1等于o2，则返回0

     */
    @Test
    public void test3(){

        String[] arr = new String[]{"AA","BB","KK","GG","JJ","DD","CC"};

        Arrays.sort(arr, new Comparator() {

            //按照字符串从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }

        });

    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods(1998, "联想");
        arr[1] = new Goods(9022, "华为");
        arr[2] = new Goods(1999, "小米");
        arr[3] = new Goods(5000, "苹果");
        arr[4] = new Goods(5000, "小米");

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Integer.compare(o1.getPrice(),o2.getPrice());
                } else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    


}
