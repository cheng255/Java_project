package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网 神奇的口袋
 * @author nuonuo
 * @create 2020-11-26 19:57
 */
public class T6 {
    private static int sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        //每个物品都可以选或者不选
        helper(arr,0,40);
        System.out.println(sum);

    }
    private static void helper(int[] arr, int index, int n) {
        if (n < 0) {
            return;
        }
        if (index >= arr.length) {
            if (n == 0) {
                sum++;
            }
            return;
        }
        if (n == 0) {
            sum++;
            return;
        }
        helper(arr, index + 1, n);
        helper(arr, index + 1, n - arr[index]);
    }
}
