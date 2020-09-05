package com.cheng.java2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-09-01 19:04
 */
public class work13 {
    public static void main(String[] args) {
        int a = 0;
        int c = 0;
        do {
            --c;
            a = a - 1;
        } while (a > 0);

        int d = 2, b = 6;
        System.out.println( (d++) + (++b) + d * b);

        System.out.println(func(4));
    }

//    验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。【不限语言】
//    例如： 1^3=1 2^3=3+5
//            3^3=7+9+11 4^3=13+15+17+19

    private static List<Integer> func(int m) {
        ArrayList<Integer> list = new ArrayList<>();
        if (m == 1) {
            list.add(1);
            return list;
        }
        int n = m * m * m;
        int mid = n / m; // 连续奇数的中位数
        if ((mid & 1) == 1) { // 如果是奇数
            list.add(mid);
        }
        int t = m / 2;
        int left = mid - 1, right = mid + 1;
        while (t > 0) {
            if ((left & 1) == 1 || (right & 1) == 1) {
                list.add(left);
                list.add(right);
                t--;
            }
            left--;right++;
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list;
    }


}
