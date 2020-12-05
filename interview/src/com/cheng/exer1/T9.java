package com.cheng.exer1;

import java.util.Arrays;

/**
 * 生成格雷码
 * @author nuonuo
 * @create 2020-12-04 21:18
 */
public class T9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T9().getGray(10)));
    }

    //递归思路  n位的gray码是由n-1位的gray码在首位加0或1得到的 0 1    00  01   10  11 长度为两倍
    public String[] getGray(int n) {
        String[] res = null;
        if (n == 1) {
            res = new String[]{"0", "1"};
        } else {
            String[] gray = getGray(n - 1);
            res = new String[gray.length * 2];
            for (int i = 0; i < gray.length; i++) {
                res[i] = "0" + gray[i];
                res[res.length - i - 1] = "1" + gray[i];
            }
        }
        return res;
    }
}
