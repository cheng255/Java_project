package com.cheng.自定义类使用HashSet和HashMap的注意要点;

/**
 * 重写hashcode和equals方法？
 */

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("gb", 18);
        Person p2 = new Person("gb", 18);

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        System.out.println(set.contains(p2));
        // 我想返回 true，必须重写 hashCode 和 equals


        /*
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "gb");
        System.out.println(map.get(p2));

         */
    }
}
