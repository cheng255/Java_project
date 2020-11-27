package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网 买苹果问题
 * @author nuonuo
 * @create 2020-11-26 14:58
 */
public class T5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = -1;
        //提供袋子类型   6个装  8个装
        // 满足6*x + 8*y == n 使得x + y尽量小
        int len1 = n / 8;//8个装袋子最多是len个
        for (int i = len1; i >= 0; i--) {//1.枚举8个装 袋子的个数
            //2.看看剩余的用6个装的袋子是否能够装下
            if ((n - i*8) % 6 == 0) {
                //能装下
                res = i + (n - i*8) / 6;
                break;
            }
        }
        System.out.println(res);
    }
}
