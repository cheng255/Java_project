package com.cheng.exer;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-01-27 16:23
 */
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split("\\.");
            if (split.length == 1) {
                //代表是10十进制的
                String tow = tenToTow(s);
                StringBuilder res = new StringBuilder();
                for (int i = 7; i < tow.length(); i+=8) {
                    res.append(towToTen(tow.substring(i-7, i+1))).append('.');
                }
                res.deleteCharAt(res.length()-1);
                System.out.println(res);
            } else {
                //代表是ip地址
                StringBuilder tow = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    tow.append(tenToTow(split[i]));
                }
                long res = towToTen(tow.toString());
                System.out.println(res);
            }
        }
    }
    //二进制转十进制
    public static long towToTen(String s) {
        long ten = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(s.length() - i - 1) == '0') {
                continue;
            }
            ten += Math.pow(2,i);
        }
        return ten;
    }
    //十进制转二进制
    public static String tenToTow(String s) {
        long n = Long.parseLong(s);
        StringBuilder tow = new StringBuilder();
        while (n > 0) {
            tow.append(n % 2);
            n /= 2;
        }
        while (tow.length() == 0 || (tow.length() % 8) != 0) {
            tow.append(0);
        }
        //得到的二进制数是反的
        return tow.reverse().toString();
    }
}
