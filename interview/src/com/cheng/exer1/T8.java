package com.cheng.exer1;

/**
 * 牛客网  机器人走方格
 * @author nuonuo
 * @create 2020-12-03 15:45
 */
public class T8 {
    public int countWays(int x, int y) {
        // write code here
        return helper(x,y,1,1);
    }
    //递归思路 ：每一次都有两个选择，走右和下 递归下去 直到到达边界为一种
    private int helper(int x, int y, int i, int j) {
        if (i == x || j == y) {
            return 1;
        }
        int right = helper(x,y,i+1,j);
        int down = helper(x,y,i,j+1);
        return right + down;
    }
}
