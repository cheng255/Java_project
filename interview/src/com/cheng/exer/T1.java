package com.cheng.exer;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2021-01-17 20:48
 */
public class T1 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = helper(p[i], s);
        }
        return res;
    }
    //判断p是否为s的子串
    public static boolean helper(String p, String s) {
        int i = 0;
        while (i < s.length() && p.charAt(0) != s.charAt(i)) {
            i++;
        }
        if (i >= s.length()) {
            return false;
        }
        for (; i < p.length(); i++) {
            if (p.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(chkSubStr(new String[]{"a", "b", "c", "d"}, 4, "abc")));
    }
}
