package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网 DNA序列
 * @author nuonuo
 * @create 2020-12-14 18:20
 */
public class T15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = scan.nextInt();
        int left = 0; int right = n - 1;
        int t = 0;//cg的最大个数
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == 'G' || s.charAt(i) == 'C')
                t++;
        }
        int l = left; int r = right; int temp = t;
        while (r < s.length()-1) {
            if (s.charAt(l) == 'G' || s.charAt(l) == 'C') {
                temp--;
            }
            ++r;
            ++l;
            if (s.charAt(r) == 'G' || s.charAt(r) == 'C') {
                temp++;
            }
            if (temp > t) {//更新结果
                t = temp;
                left = l;
                right = r;
            }
            if (temp == n) {
                break;
            }
        }

        System.out.println(s.substring(left,right+1));
    }
}
