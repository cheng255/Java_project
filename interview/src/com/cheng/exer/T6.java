package com.cheng.exer;

import java.util.Scanner;

/**
 * 年会抽奖
 *
 * 注意：不通过的时候可能是int类型长度不够用
 * @author nuonuo
 * @create 2021-01-30 10:16
 */
public class T6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int i = 2;
            double a = 0;
            double b = 1;
            double c = 1;
            while (i < n) {
                c = i*(a + b);
                a = b;
                b = c;
                i++;
                System.out.println(c);
            }
            //c是无人获奖的数量
            double sum = 1;
            for (int j = 1; j <= n; j++) {
                sum*=j;
            }
            sum = (c / sum)*100;
            System.out.printf("%.2f", sum);
            System.out.println("%");
        }
    }
}
