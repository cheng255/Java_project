package com.cheng.map的使用;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> 通讯录 = new TreeMap<>();

        通讯录.put("B", 119);
        通讯录.put("C", 110);
        通讯录.put("A", 114);
        通讯录.put("E", 114);

        /*
        Set<String> keys = 通讯录.keySet();
        System.out.println(keys);

        Collection<Integer> values = 通讯录.values();
        System.out.println(values);
         */

        Set<String> keys = 通讯录.keySet();
        for (String key : keys) {
            Integer value = 通讯录.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("========================");
        Set<Map.Entry<String, Integer>> entries = 通讯录.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
