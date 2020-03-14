package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Collections:操作Collection, Map的工具类
 *
 * @author nuonuo
 * @create 2020-03-14 17:49
 */
public class CollectionsTest {


    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(13);
        list.add(143);
        list.add(143);
        list.add(143);
        list.add(3);
        list.add(23);

        System.out.println(list);
        //反转 reverse()
        Collections.reverse(list);
        System.out.println(list);

        //随机排序shuffle
        Collections.shuffle(list);
        System.out.println(list);

        //sort()生序排序
        Collections.sort(list);
        System.out.println(list);

        //swap()交换
        Collections.swap(list,1,2);
        System.out.println(list);

        //frequency():返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list, 143));

        //void copy(List dest,List src):将src中的内容复制到dest中

        //错误，报异常 IndexOutOfBoundsException("Source does not fit in dest")
//        ArrayList dest = new ArrayList();
//        Collections.copy(dest,list);

        //正确操作
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

        /*
    Collections 类提供了多个synchronizedXxx(),该方法可使指定集合包装成线程同步的集合
    从而可以解决多线程并发访问集合时的线程安全问题

     */
        List list1 = Collections.synchronizedList(list);
        System.out.println("线程安全：" + list1);

    }

}
