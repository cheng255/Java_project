package com.cheng.exer2;

import java.util.*;

/**
 * 牛客网：电话号码
 * @author nuonuo
 * @create 2021-03-17 23:14
 */
public class TelephoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextInt();
            Set<String> set = new LinkedHashSet<>();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                s = s.replace("-", "");
                set.add(func(s));
            }
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
    static String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String number="22233344455566677778889999";
    private static String func(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(number.charAt(symbol.indexOf(c)));
                continue;
            }
            sb.append(c);
        }
        if (sb.length() > 0)
            sb.insert(3, "-");
        return sb.toString();
    }
}
