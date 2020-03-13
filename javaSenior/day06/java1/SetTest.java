package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * Collection接口：单列数据，定义了存取一组对象的方法的集合（一个一个的对象）
 *
 *       Set接口:元素无序，不可重复的集合 --> 高中函数 y = f(x)
 *          |---HashSet: 作为Set接口的主要实现类：线程不安全，可以存储null值
 *               |---LinkedHashSet：作为HashSet的子类， 遍历其内部数据时，可以按照添加的顺序遍历
 *                                  对于频繁的遍历操作，LinkedHashSet效率高域HashSet
 *          |---TreeSet：可以按照添加的对象的指定属性进行排序，向TreeSet中添加数据，要求是相同类的对象
 * @author nuonuo
 * @create 2020-03-13 10:36
 */
public class SetTest {
    /*

   一： Set接口:

        以HashSet为例说明
        1.元素无序性: 不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。而是根据数据的哈希值决定

        2.不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个


    二：添加元素的过程：以HashSet为例
        我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()，计算元素a的哈希值
        此哈希值接着通过某种算法计算出HashSet底层数组中的存放位置（即为：索引位置），判断
        数组此位置上是否已经有元素。
            如果此位置上没有元素，则a添加成功 -->  情况1
            如果此位置上有其他元素b（或yi链表形式存在的多个元素），则比较元素a和元素b的hash值
                如果hash值不同，则元素a添加成功 --> 情况2
                如果hash值相同，进而需要带哦用元素a所在类的equals方法：
                    如果equals方法返回true，表明元素a添加失败
                    如果equals方法返回false，则元素a添加成功---> 情况3

        对于添加成功的情况2和情况3而言：元素a 和 已经存在指定索引位置上的数据以链表方式存储
        jdk7： 元素a放到数组中，指向原来的元素
        jdk8： 原来数组中的元素指向元素a
        总结：七上八下

        HashSet底层其实是数组加链表的结构

     */
    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("ABC");
        set.add(new Person("Tom",15));
        set.add(new Person("Tom",15));
        set.add("CDE");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
    @Test
    public void test2(){
        LinkedHashSet set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("ABC");
        set.add(new Person("Tom",15));
        set.add(new Person("Tom",15));
        set.add("CDE");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
