package com.cheng.exer;

/**
 * 牛客网  上楼梯
 *
 * 难点：  使用long
 * @author nuonuo
 * @create 2021-02-04 13:27
 */
public class T11 {
    public static void main(String[] args) {
        System.out.println(countWays(6));
    }
    public static int countWays(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        long a = 1;
        long b = 2;
        long c = 4;
        long d = 0;
        for (int i = 4; i <= n; i++) {
            d = (a + b + c) % 1000000007;
            a = b;
            b = c;
            c = d;
        }
        return (int)d;
    }
}
