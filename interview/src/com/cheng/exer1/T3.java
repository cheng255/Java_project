package com.cheng.exer1;

import java.util.Scanner;

/**
 * 输出一个字符串中最长的数字子串
 * @author nuonuo
 * @create 2020-11-26 13:31
 */
public class T3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.length() == 0) {
            return;
        }
        int r = 0; int max = 0; int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                //不是数字
                if (i - j > max) {//更新最大数字串的长度和前下标
                    max = i - j;
                    r = j;
                }
                j = i + 1;
            } else if (i == str.length() - 1) {
                //是数字并且是最后一个
                if (i - j + 1 > max) {//更新最大数字串的长度和前下标
                    max = i - j + 1;
                    r = j;
                }
            }
        }
        System.out.println(str.substring(r,r+max));
    }
}
