package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网：尼克砌斯定理
 * @author nuonuo
 * @create 2020-12-08 13:17
 */
public class T10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int m = scan.nextInt();
            String s = GetSequeOddNum(m);
            System.out.println(s);
        }
    }

    public static String GetSequeOddNum(int m) {
        int n = (m*m*m) / m;//中间数
        int[] a = new int[m];
        int index = (m-1) / 2;//中间数下标
        int l = index - 1;
        int r = index + 1;
        if ((n & 1) == 1) {
            //奇数
            a[index] = n;
        } else {
            l = index;
        }
        int nn = n;
        if ((n & 1) == 1) {
            //本身就是奇数要跳过
            nn--;
        }
        while (l >= 0) {
            if ((nn & 1) == 1) {
                a[l] = nn;
                nn-=2;
                l--;
            } else {
                nn -= 1;
            }
        }
        nn = n;
        if ((n & 1) == 1) {
            //本身就是奇数要跳过
            nn++;
        }
        while (r < a.length) {
            if ((nn & 1) == 1) {
                a[r] = nn;
                nn+=2;
                r++;
            } else {
                nn += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i != 0) {
                sb.append("+");
            }
            sb.append(a[i]);
        }
        return sb.toString();
    }
}
