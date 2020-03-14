package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 *
 *  |-----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序和定制排序
 *                         底层使用的红黑树
 *
 *
 * @author nuonuo
 * @create 2020-03-14 14:32
 */
public class TreeMapTest {
@Test
    public void test(){
    TreeMap map = new TreeMap();
    User u1 = new User("Tom",12);
    User u2 = new User("Anny",12);
    User u3 = new User("Jerry",11);
    User u4 = new User("Mark",18);
    User u5 = new User("Sonny",14);
    map.put(u1,50);
    map.put(u2,60);
    map.put(u2,80);
    map.put(u3,70);
    map.put(u4,20);
    map.put(u5,80);
    Set entrySet = map.entrySet();
    Iterator iterator1 = entrySet.iterator();
    while (iterator1.hasNext()) {
        Object obj = iterator1.next();
        //entrySet集合中的元素都是entry
        Map.Entry entry = (Map.Entry) obj;
        System.out.println(entry.getKey() + "--->" + entry.getValue());


    }

}
@Test
    public void test1(){
    TreeMap map = new TreeMap(new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof User && o2 instanceof User) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                if (Integer.compare(u1.getAge(), u2.getAge()) == 0) {
                    return u1.getName().compareTo(u2.getName());
                } else{
                    return -Integer.compare(u1.getAge(), u2.getAge());
                }
            } else{
                return 0;
            }
        }
    });
    User u1 = new User("Tom",12);
    User u2 = new User("Anny",12);
    User u3 = new User("Jerry",11);
    User u4 = new User("Mark",18);
    User u5 = new User("Sonny",14);
    map.put(u1,50);
    map.put(u2,60);
    map.put(u2,80);
    map.put(u3,70);
    map.put(u4,20);
    map.put(u5,80);

    Set entrySet = map.entrySet();
    Iterator iterator1 = entrySet.iterator();
    while (iterator1.hasNext()) {
        Object obj = iterator1.next();
        //entrySet集合中的元素都是entry
        Map.Entry entry = (Map.Entry) obj;
        System.out.println(entry.getKey() + "--->" + entry.getValue());


    }


}
}
