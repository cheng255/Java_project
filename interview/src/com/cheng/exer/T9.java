package com.cheng.exer;

import java.util.Scanner;

/**
 * 牛客网 数字和为sum的方法数
 *dp[i][j] :代表用前i个数字凑到j最多方案
 * dp[i][j] = dp[i-1][j] : 不用第i个数字凑到j的最多方案
 * dp[i][j] + = dp[i-1][j-value[i]] : 用第i个数字，只需要看原来凑到j-value[j]的最多方案，并累加
 * dp[0] = 1 : 初始化，表示凑到0永远有1中方案
 *
 * @author nuonuo
 * @create 2021-02-02 14:04
 */
public class T9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        long[][] dp = new long[n + 1][sum + 1];//dp[i][j] 表示前i个凑到j的方式数
        //初始化dp,用前i个组成和为0的方案，只有1种，就是什么都不取，和为0；
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        //用0个元素不能组成1~sum
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num)
                    dp[i][j] += dp[i - 1][j - num];
            }
        }
        System.out.println(dp[n][sum]);
    }
}
