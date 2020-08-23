package com.cheng.java2;

import org.junit.Test;

/**
 * @author nuonuo
 * @create 2020-08-23 9:36
 */
public class work02 {
    //    求一个十进制数字在内存中二进制1的个数。要求：正数和负数都可以求，并且时间最优【不限语言】
    private static int getNumberOfBinaryOne(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        System.out.println(res);
        return res;
    }

    @Test
    public void test() {
        getNumberOfBinaryOne(10);
    }
}
