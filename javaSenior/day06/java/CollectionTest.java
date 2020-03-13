package com.atguigu.java;

import org.junit.Test;

import java.util.*;


/**
 *
 * 集合框架
 *
 *      数组一旦初始化以后，长度和类型就确定了，不可修改。  于是集合的作用更为广泛，更方便
 *      数组是有序，可重复的，但对于无序，不可重复的需求不能满足
 *
 *
 * 分类
 *
 *      Collection接口：单列数据，定义了存取一组对象的方法的集合（一个一个的对象）
 *
 *          List接口:元素有序，可重复的集合 --> “动态”数组
 *          |---ArrayList,LinkedList,Vector
 *          Set接口:元素无序，不可重复的集合 --> 高中函数 y = f(x)
 *          |---HashSet,LinkedHashSet,TreeSet
 *
 *      Map接口：双列数据， 保存具有映射关系“key-value对”的集合（一对的数据）
 *          |---HashMap,LinkedHashMap,TreeMap,Hashtable,Properties
 *
 *
 *  Collection接口中的方法的使用
 *
 *  向Collection接口的实现类的对象中佳田拘束obj时，要求obj所在类要重写equals()
 *
 *
 * @author nuonuo
 * @create 2020-03-12 13:45
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection c1 = new ArrayList();

        //add(Object e):将元素e添加到集合中
        c1.add("ABB");
        c1.add("AB");
        c1.add(123);//自动装箱
        c1.add(new Date());

        //size()：获取添加的元素的个数
        System.out.println(c1.size());

        //addAll(Collection coll):将coll集合中的元素添加到当前的集合中
        Collection c2 = new ArrayList();
        c2.add("ab");
        c2.add("abcd");
        c1.addAll(c2);
        System.out.println(c1.size());
        System.out.println(c1);

        //clear():清空集合元素
        c1.clear();
        System.out.println(c1.size());
        System.out.println(c1);

        //isEmpty():判断当前集合是否为空
        System.out.println(c1.isEmpty());

        System.out.println("************");

        //contains(Object obj): 判断当前集合中是否包含obj,  只关乎内容，不关乎地址
                    //判断时会调用obj对象所在类的equals()。
        boolean b = c2.contains(new String("abcd"));
        System.out.println(b);//true
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("张三", 18);
        c2.add(123);
        c2.add(p1);
        System.out.println(c2.size());
        System.out.println(c2.contains(p2));//false,因为Person类中没有重写equals,重写后为true

        //containsAll(Collection coll1):判断形参Coll1中的所有元素是否都存在于当前集合中
        Collection c3 = Arrays.asList(123,"adad",21);
        System.out.println(c2.containsAll(c3));


    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("ABB");
        coll.add(new String("ABC"));
        coll.add(123);//自动装箱
        coll.add(new Date());
        coll.add(new Person("张三",18));

        //remove(Object obj):也会调用equals()，返回值为boolean
        System.out.println(coll.remove(new Person("张三", 18)));

        //removeAll(Collection coll1):从当前集合中移除Coll1中所有的元素（差集）

        //retainALl(Collection coll1):保留当前集合中和coll1中交集的部分

        //equals(Object obj)判断当前集合和形参集合是否相等，返回boolean值

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合 --> 数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //数组 --> 集合
        List list = Arrays.asList(12, 23, 445);
        System.out.println(list);

        List ints = Arrays.asList(new int[]{12, 23, 45});
        System.out.println(ints);//[[I@78e03bb5]
        List ints1 = Arrays.asList(new Integer[] {12, 23, 45});
        System.out.println(ints1);//[12, 23, 45]



        //iterator():返回Iterator接口的示例，用于遍历集合元素，放在IteratorTest.java中测试


    }



}
