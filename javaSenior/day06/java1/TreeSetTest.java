package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * TreeSet类测试
 *
 * @author nuonuo
 * @create 2020-03-13 14:21
 */
public class TreeSetTest {

    /*

    1.向TreeSet中添加数据，要求是相同类的对象
    2.两种排序方式，   自然排序 和 定制排序


    3.自然排序中，比较两个对象是否相同的标准为：compareTo返回0，不再时equals()。

     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

//        举例一：
//        set.add(123);
//        set.add(123);
//        set.add(456);
//        set.add(-34);
//        set.add(32);

        //举例二：添加自定义类

        set.add(new User("Tom",12));
        set.add(new User("Anny",12));
        set.add(new User("Jerry",11));
        set.add(new User("Mark",18));
        set.add(new User("Sonny",14));
        set.add(new User("Nid",13));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            //按照年龄升序，再按照姓名升序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    if (Integer.compare(user1.getAge(), user2.getAge()) == 0) {
                        return user1.getName().compareTo(user2.getName());
                    }else{
                        return -Integer.compare(user1.getAge(),user2.getAge());
                    }
                }else{
                    throw new RuntimeException("数据类型不一致");

                }


            }
        });
        set.add(new User("Tom",12));
        set.add(new User("Anny",12));
        set.add(new User("Jerry",11));
        set.add(new User("Mark",18));
        set.add(new User("Sonny",14));
        set.add(new User("Nid",13));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
