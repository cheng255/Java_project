package com.cheng.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-08-27 16:36
 */
public class work06 {

    public static void main(String[] args) {
        System.out.println(getJustOneTimeNumber(new int[]{1, 3, 5, 7, 1, 3, 5, 9}));
    }

/*    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。【不限语
    言】
    例如:数组为{1，3，5，7，1，3，5，9}，找出7和9。*/


    /*思路： 使用^  因为相同的数 ^ 得到的结果为0
       1.先异或运算一次，设结果为n，假设两个不同的数字为a,b  则： n = a ^ b;
       2.找到n的二进制第k位，第k位上的数要是1
       3.通过第k位上的数是否1作为条件 将数组分为两个数组，（其目的可以将相同的数字分到一组，a 和 b 分开放置）
       4.两组数据分别异或，结果便是答案
    */
    private static List<Integer> getJustOneTimeNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int n = arr[0];
        for (int i = 1; i < arr.length; i++) {
            n ^= arr[i];
        }
        int k = 0;
        while ((n & 1) != 1) {
            k++;
            n >>>= 1;
        }
        int x = (int) Math.pow(2, k);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & x) != 0) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < list1.size(); i++) {
            cur ^= list1.get(i);
        }
        res.add(cur);
        cur = 0;
        for (int i = 0; i < list2.size(); i++) {
            cur ^= list2.get(i);
        }
        res.add(cur);

        return res;
    }


}

class NULL {
    public static void print() {
        System.out.println("MTDP");
    }

    public static void main1(String[] args) {
        try {
            ((NULL) null).print();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
}
