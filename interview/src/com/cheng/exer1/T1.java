package com.cheng.exer1;

import java.util.Scanner;

/**
 * 统计回文
 * @author nuonuo
 * @create 2020-11-23 23:57
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strA = scan.nextLine();
        String strB = scan.nextLine();
        int res = 0;
        for (int i = 0; i <= strA.length(); i++) {
            StringBuilder sb = new StringBuilder(strA.substring(0,i));
            sb.append(strB).append(strA.substring(i,strA.length()));
            if (check(sb.toString())) {
                res++;
            }
        }
        System.out.println(res);
    }
    private static boolean check(String s) {
        int l = 0; int r = s.length() - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++; r--;
        }
        if (l > r) {
            return true;
        }
        return false;
    }
}
