package com.cheng.exer;

/**
 *
 * 最长公共子序列
 * @author nuonuo
 * @create 2020-10-18 22:46
 */
public class exer2 {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "abcdefghi";
        int[][] dp = new int[s1.length()][s2.length()]; //记录
        longestCommonSub(s1, s2);
    }

    //思路：先比较当前两个元素  如果相同
    private static void longestCommonSub(String s1, String s2) {

    }


}
