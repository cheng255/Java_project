package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 *
 *
 * 1.List接口框架结构
 *       Collection接口：单列数据，定义了存取一组对象的方法的集合（一个一个的对象）
 *
 *           List接口:元素有序，可重复的集合 --> “动态”数组
 *            |---ArrayList ：作为List接口的主要实现类，线程不安全，效率高，底层使用Object[] elementData存储
 *            LinkedList  ：对于频繁的插入，删除操作，使用此类效率更高，底层使用双向链表存储
 *            Vector  ：List接口的古老实现类，线程安全，效率低，底层使用Object[] elementData存储
 *
 *
 * 2.      ArrayList的源码分析：
 *
 *   2.1    jdk7情况下：
 *
 *       ArrayList list = new ArrayList(): 底层创建了长度为10的Object[] elementData
 *       list.add(123); elementData[0] = new Integer(123);
 *
 *       ..
 *       list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容，，默认情况下扩容1.5倍，
 *                      同时需要将原有的数据复制到新的数组中。
 *
 *              结论：建议开发中使用带参的构造器，ArrayList list = new ArrayList(int initialCapacity)
 *  2.2     jdk8中的变化
 *       ArrayList list = new ArrayList():底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *
 *       list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData。。
 *
 *       小结欸：jdk7中的ArrayList对象的创建类似于单例的饿汉式，中的ArrayList对象的创建类似于单例的懒汉式，
 *              延迟了数组的创建，节省内存
 *
 *
 * 3.      LinkedList的源码分析：
 *
 *       LinkedList list = new LinkedList(); 内部生命了Node类型的first和last属性，默认值为null
 *       List.add(123);//将123封装到Node中，创建了Node对象，并成链表
 *
 *       其中，Node定义为： 双向链表
 *    private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *
 *
 * * 面试题：ArrayList,LinkedList,Vector 三者的异同
 *
 * 同：三个类都是实现了List接口，存储数据的特点相同：有序，可重复
 *
 * 不同：
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-13 8:26
 */
public class ListTest {

 // 4.    List接口中的常用方法，主要   增删改查，长度，遍历
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",18));


        //遍历


        //方式一：Iterator迭代器方式

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("**********");
        //方式二：增强for循环
        for(Object obj : list){
            System.out.println(obj);
        }


        //方式三：for循环

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",18));

        System.out.println(list);

        //void add(int index, Object ele):在index索引位置插入ele元素
        list.add(1,"CC");
        System.out.println(list);

        //boolean addAll(int index, Collection ele): 从index位置开始将ele中所有的元素添加进来

        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));

        //int indexOf(Object obj):返回obj在当前集合中首次出现的位置，没有返回-1

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置，没有返回-1

        System.out.println(list.indexOf("CC"));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(1));
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置上的元素为ele,   return oldValue;
        System.out.println(list.set(1, "CC"));
        System.out.println(list);

        //List subList(int fromIndex, int toIndex): 返回左闭右开子集合

        System.out.println(list.subList(0, 2));


    }
}
