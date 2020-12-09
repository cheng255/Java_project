package com.cheng.exer1;

import java.util.Scanner;

/**
 * 牛客网 饥饿的小易  题解
 * @author nuonuo
 * @create 2020-12-09 17:50
 */
public class T12 {
    //1. g(f(x)) = f(g(x)) 即f和g的执行顺序没有影响
    //2. f(f(f(x))) = g(g(x)) 即做3次f的变换等价于做2次g的变换
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();//初始位置
        long m = 1000000007;//取模的值
        long maxStep = 100000;
        long[] begin = new long[3];//三个执行8*x+7的初始的三个位置
        begin[0] = x;
        begin[1] = (begin[0]*4+3) % m;
        begin[2] = (begin[1]*4+3) % m;
        long minStep = maxStep;
        long cur = 0;
        int step = 0;
        for (int i = 0; i < 3; i++) {//分别算着三个初始位置到达指定点的步数
            step = i;//初始化步数
            cur = begin[i];
            while (cur != 0 && step < minStep) {
                //没找到贝壳并且比min步数少就继续找
                cur = (cur*8 + 7) % m;
                step++;
            }
            minStep = minStep < step ? minStep : step;//记录这三个初始位置哪个能用最小的步数找到贝壳
        }
        if (minStep < maxStep) {
            System.out.println(minStep);
        } else {
            System.out.println(-1);
        }
    }
}
