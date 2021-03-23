package com.cheng.exer2;

import java.util.Stack;

/**
 * 左右最值最大差
 * @author nuonuo
 * @create 2021-03-23 16:37
 */
public class MaxDifference {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int res = 0;
        int k = -1;
        //1.起初就算是k为-1位置，都是右半部分，所以左半部分的最大值没有，右半部分的最大值就是数组的最大值
        //需要把右半部分也就是整个数组构成一个单调栈
        int lMax = Integer.MIN_VALUE;
        Stack<Integer> maxStack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (maxStack.isEmpty()) {
                maxStack.push(A[i]);
                continue;
            }
            maxStack.push(A[i] > maxStack.peek() ? A[i] : maxStack.peek());
        }
        //2.慢慢将k从0移动到n-2位置，并动态记录左右最大值的变化
        for (k = 0; k <= n - 2; k++) {
            lMax = lMax > A[k] ? lMax : A[k];
            maxStack.pop();

            int ab = Math.abs(lMax - maxStack.peek());
            res = res > ab ? res : ab;
        }
        return res;
    }
}
