package com.cheng.exer;

import java.util.HashMap;

/**
 * @author nuonuo
 * @create 2021-01-20 12:28
 */
public class T2 {
    /**
     1.找出无序数组当中，出现次数超过数组长度一半的数字。【不限语言】
     *2.如果没有 返回0
     */
    public int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(gifts[i])) {
                int t = map.get(gifts[i]);
                if (t == n / 2) {
                    return gifts[i];
                }
                map.put(gifts[i], t+1);
            } else if (i <= n / 2 + 1){
                map.put(gifts[i], 1);
            }
        }
        return 0;

    }
    private static int findMoreNumber(int[] arr) {
        // 思路：定义sum  如果当前数字和前一个数字相同的话 sum++
//                        如果和前一个数字不相同的话 sum--
//                        当sum为0的时候，更新下标
        int sum = 1, temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum == 0) {
                temp = arr[i];
            }
            if (arr[i] == temp) {
                sum++;
            } else {
                sum--;
            }
        }
        return temp;
    }
}
