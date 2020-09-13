package com.cheng.java3;

/**
 * @author nuonuo
 * @create 2020-09-06 13:14
 */
public class Test01 {
    public static void main(String[] args) {
        String s = "bababacc";
        int res = manacher(s);
        System.out.println("The maxR=" + res);
    }

    private static int manacher(String s) {
        char[] pre = s.toCharArray();
        char[] now = new char[s.length()*2+1];
        //1.将每一位前后都加上占位符#,为了防止偶数个字符的情况， 算出的回文长度/2就是结果
        now[0] = '#';
        for (int i = 1, j = 0; i < now.length; i+=2, j++) {
            now[i] = pre[j];
            now[i+1] = '#';
        }
        //2.变量bound记录当前的最右  的回文右边界, 初始化-1
        int bound = -1;

        int[] r = new int[now.length];//记录以每个字符为中心的最大回文半径
        r[0] = 0;
        bound = 0;
        int maxR = r[0];//记录最大回文半径

        int c = 0;//记录当前的 最右回文右边界 的中心点下标
        int left = -1;
        int right = 1;
        for(int i = 1; i < now.length; i++) {//第一位#不用判断

            if(bound < i) {//当前字符 在 最右 的回文右边界 外部==>暴力搜索
                left = i-1;
                right = i+1;
                while(left >= 0 && right <= now.length-1 && now[left] == now[right]) {
                    left--;
                    right++;
                }
                r[i] = right-1-i;//记录回文半径
                if(right-1 > bound) {//更新最右回文右边界和中心点
                    bound = right-1;
                    c = i;
                }

            }else {//当前字符 在 最右 回文右边界 内部
                //判断以c为中心的i的对称点的回文半径和c的回文左边界的关系， 1.外 2.内 3.同一个位置
                int i1 = c - (i-c);//i相对于c的对称点i1
                int l = Math.abs(left+1 - i1);//c的回文左边界到i1的距离

                if(r[i1] >= l) {
                    //相同线上,从边界的下一个开始扩
                    int left1 = i - l - 1;
                    int right1 = i + l + 1;
                    while(left1 >= 0 && right1 <= now.length-1 && now[left1] == now[right1]) {
                        left1--;
                        right1++;
                    }
                    r[i] = right1-1-i;//记录回文半径
                    if(right1-1 > bound) {//更新最右回文右边界和中心点
                        bound = right-1;
                        c = i;
                        left = left1;
                        right = right1;
                    }

                }else {//内或外
                    r[i] = r[i1];
                }

            }
            //更新最大回文半径
            maxR = Math.max(maxR, r[i]);
        }
        return maxR;
    }
}
