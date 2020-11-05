package java中哈希表的应用;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        System.out.println(set);    // 不保证顺序
//        System.out.println(set.add(1));
//        System.out.println(set);
//
//        System.out.println(set.remove(3));
//        System.out.println(set);
//
//        System.out.println(set.contains(1));
//        System.out.println(set.contains(4));

        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.put("pxc", 123));
        System.out.println(map.put("pxc", 456));
        map.put("gb", 777);
        map.put("tz", 999);

        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
