package com.cheng.exer1;

/**
 * 牛客网：另类加法 day15 题解
 * @author nuonuo
 * @create 2020-12-09 16:31
 */
public class T11 {
    public static void main(String[] args) {
        System.out.println(2 ^ 10);
    }
    public int addAB(int A, int B) {
        //A 和 B 异或操作是      101+111  -> 1100   不算进位10   进位的左移一位后1010  继续相加
        // 第二轮                    不算进位1000   进位100  继续相加  不算进位1100 进位0时结束
        int XOR = 0;
        int AND = 0;
        while (true) {
            XOR = A^B;
            AND = (A&B)<<1;
            if (AND == 0) {
                break;//这时XOR为答案
            }
            A = XOR;
            B = AND;
        }
        return XOR;
    }
}
