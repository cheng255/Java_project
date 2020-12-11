package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网 洗牌  （可优化）
 * @author nuonuo
 * @create 2020-12-10 20:42
 */
public class T13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] nums = new long[n*2];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextLong();
            }
            for (int j = 0; j < k; j++) { // 洗牌k次
                nums = func(nums);
            }
            if (nums.length > 0) {
                System.out.print(nums[0]);
            }
            for (int j = 1; j < nums.length; j++) {
                System.out.print(" " + nums[j]);
            }
            System.out.println();
        }
    }
    private static long[] func(long[] nums) {
        long[] news = new long[nums.length];
        int n = nums.length / 2;
        for (int i = 0,j = 0; i < news.length; i+=2,j++) {
            news[i] = nums[j];
            news[i+1] = nums[n+j];
        }
        return news;
    }
}
