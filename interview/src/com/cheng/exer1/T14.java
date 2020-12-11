package com.cheng.exer1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-12-10 22:15
 */
public class T14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            List<String> list = new ArrayList<>();
            func(arr, 0, list);
            list.sort(String::compareTo);
            for (String s : list) {
                System.out.print(s.charAt(0));
                for (int i = 1; i < s.length(); i++) {
                    System.out.print(" " + s.charAt(i));
                }
                System.out.println();
            }
        }
    }
    private static void func(int[] arr, int k, List<String> list) {
        if (k >= arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            list.add(sb.toString());
            return;
        }
        //每个数字都和后面每一位交换
        for (int i = k; i < arr.length; i++) {
            {int temp = arr[i]; arr[i] = arr[k]; arr[k] = temp;}
            func(arr, k+1, list);
            {int temp = arr[i]; arr[i] = arr[k]; arr[k] = temp;}
        }
    }
}
