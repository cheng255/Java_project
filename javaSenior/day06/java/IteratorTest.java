package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * 集合元素的遍历操作：使用Iterator接口    称为迭代器
 *
 * @author nuonuo
 * @create 2020-03-12 20:30
 */
public class IteratorTest {
    //测试遍历操作

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("ABB");
        coll.add(new String("ABC"));
        coll.add(123);//自动装箱
        coll.add(new Date());
        coll.add(new Person("张三",18));

        Iterator iterator = coll.iterator();
//      方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //方式二： 不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：  推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
    //测试Iterator中的remove():可以删除集合中的元素，此方法不同于集合直接调用remove()

    //注意

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("ABB");
        coll.add(new String("ABC"));
        coll.add(123);//自动装箱
        coll.add(new Date());
        coll.add(new Person("张三",18));
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if(next == "ABB"){
                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


    }
}
