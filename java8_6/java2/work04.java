package com.cheng.java2;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-08-25 11:20
 */
public class work04 {
    public static void main(String[] args) {
        getLastKMinNumber(new int[]{1,2,3,2,2,2,5,4,2}, 3);
    }
    //求一个数组中前k个最小的数字。【不限语言】
//如：{1,2,3,2,2,2,5,4,2} 当k等于3为。前3个最小的数字为 1 2 2
    private static int[] getLastKMinNumber(int[] arr, int k) {
        if (arr.length < k || k <=0) {
            return null;
        }
        //思路：用一个数组存储k个最小的元素，进行更新换代
        int[] res = Arrays.copyOf(arr, k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]) {
                res[0] = arr[i];
            } else if (arr[i] < res[1]) {
                res[1] = arr[i];
            } else if (arr[i] < res[2]) {
                res[2] = arr[i];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;

    }
}


class Test {
    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] argv) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }

//        Test.class.getMethod("foo").invoke()
    }
}
