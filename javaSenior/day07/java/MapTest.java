package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 一：Map的实现类结构
 *
 *       Map接口：双列数据， 保存具有映射关系“key-value对”的集合（一对的数据）
 *           |---HashMap:作为Map的主要实现类：线程不安全，效率高：可存储null的value或key
 *                  |----LinkedHashMap:保证在遍历Map元素时，可以按照添加的顺序实现遍历。
 *                             原因：在原有的HashMap低层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                             对于频繁的遍历操作，此类执行效率要更高。
 *           |-----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序和定制排序
 *                          底层使用的红黑树
 *           |----Hashtable:作为Map的古老实现类：线程安全，效率低：不能存储null的value和key
 *           |-----Properties:Hashtable的子类，常用来处理配置文件。key和value都是String类型
 *
 *
 *        HashMap的底层： 数组+链表 (jdk7及以前)
 *                       数组+链表+红黑树 （jdk8）
 *
 *
 *      面试题：
 *      1.HashMap的底层原理？
 *      2.HashMap和Hashtable的异同？
 *      3.CurrentHashMap 和 Hashtable 的异同？
 *
 *
 *
 * 二：Map结构的理解：
 *      Map中的key：无序的，不可重复的，使用Set存储所有的key --> key所在的类要重写equals()和hashCode() （以Hash为例）
 *      Map中的value：无序的，可重复的，使用Collection存储所有的value -->value所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象。
 *      Map中的entry：无序的，不可重复的，使用Set存储所有的entry
 *
 *
 * 三：HashMap的底层实现原理？ （以jdk7为例）
 *  >>    HashMap map = newHashMap();
 *      在实例化以后，底层创建了一个长度为16的一维数组Entry[] table。
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1):
 *      首先，计算调用kay1所在类的hashCode()计算key1哈希值，此哈希值经过某种计算方法后，得到在Entry[]中的存放位置
 *      如果此位置上的数据为空，此时的key1-value1添加成功。---情况1
 *      如果此位置上的数据不为空（意味着此位之上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或
 *      多个数据的哈希值：
 *                  如果key1的哈希值和已经存在的哈希值都不相同，此时key1-value1添加成功。---情况2
 *                  如果key1的哈希值和已经存在的某一个数据key2的哈希值相同，继续比较：调用key1所在类的equals()，比较
 *                          如果equals()返回false：此时key1-value1添加成功 --- 情况3
 *                          如果equals()返回true：使用value1替换key2的value2。
 *
 *          补充：关于情况2和情况3：此时key1-value2和原来的数据以链表的方式存储
 *
 *
 *          在不断地添加过程中，会涉及到扩容问题：当超出临界值时（且要存放的位置非空时）默认的扩容方式：
 *          扩容为原来容量的2倍，并将原有的数据复制过来
 *
 *    >>      jdk8  相较于jdk7在底层实现方面的不同：
 *          1.new HashMap():底层没有创建一个长度为16的数组
 *          2.jdk 8底层的数组是： Node[]，而非Entry[]
 *          3.首次调用put()时，底层才创建长度为16的数组
 *          4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 *            当数组的某一个索引为止上的元素以链表形式存在的数据个数 > 8 且当前数组长度 >64时，
 *            此时此索引位置上的所有数据改为使用红黑树存储，如果 当前数组长度 <64 只需要扩容
 *
 *
 *          DEFAULT_LOAD_FACTOR:HashMap的默认加载因子：0.75
 *          threshold:扩容的临界值， = 容量 * 填充因子：默认 16 * 0.75 = 12
 *          DEFAULT_INITIAL_CAPACITY： HashMap的默认容量：16
 *          TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，则转化为红黑树，默认值：8
 *          MIN_TREEIFY_CAPACITY:桶中的Node被树化时最小的hash表容量：64
 *
 *
 *
 *   四：LinkedHashMap的底层实现原理
 *          源码中内部类：（在HashMap的内部类Node的基础上加了before和after指针）
 *         static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 *
 *  五：Map中定义的方法
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-14 10:08
 */
public class MapTest {


    /*
    元视图操作的方法：

     */

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",12);
        map.put("YY",45);
        map.put("KK",23);
        map.put("BB",12);
        map.put("FF",12);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }

        //遍历所有的key-value

//        方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());


        }
    }



    /*
    基础方法
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        //添加put()
        map.put("AA",12);
        map.put("YY",45);
        map.put("KK",23);
        map.put("BB",12);
        map.put("FF",12);
        //修改
        map.put("AA",67);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("PP",67);
        map1.putAll(map);
        System.out.println(map1);

        //移除remove()
        Object value = map.remove("AA");
        System.out.println(value);
        System.out.println(map);

        //清理clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());
        System.out.println(map);

        //get()
        //isEmpty
        System.out.println(map.isEmpty());
        System.out.println(map1.containsKey("AA"));
        System.out.println(map1.containsValue(123));

    }


    @Test
    public void test1(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(null,12);
        map.put(12,"ad");
        map.put(4,"dc");
        map.put(2,"dc");
        map.put(2,"cc");
        System.out.println(map);
    }
}
