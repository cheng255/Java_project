package com.cheng.exer;

import java.util.*;

/**
 * 简单错误记录
 * @author nuonuo
 * @create 2021-02-01 19:42
 */
public class T8 {
    /**
     * 重点在于使用LinkedHashMap   再使用
     * List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
     * 就可以对数据进行排序
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //思路： 使用LinkedHashMap key为文件名称和行号，value为条数  即可解决
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split("\\\\");
            String pow = split[split.length-1];
            if (map.containsKey(pow)) {
                map.put(pow, map.get(pow)+1);
            } else {
                map.put(pow, 1);
            }
        }
        //使用LinkedList对数据进行排序   注意java的排序是归并排序  是稳定的
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)-> {
            return b.getValue() - a.getValue();
        });
        //到这输出就行了  注意删选文件名超过16个字符的
        int m = 0;
        for (Map.Entry<String, Integer> e :list) {
            if (m >= 8) {
                break;
            }
            String fileAndPow = e.getKey();
            String[] split = fileAndPow.split(" ");
            if (split[0].length() > 16) {
                split[0] = split[0].substring(split[0].length()-16);
            }
            System.out.println(split[0] + " " + split[1] + " " + e.getValue());
            m++;
        }
    }
}
