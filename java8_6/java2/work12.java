package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-09-01 18:45
 */
public class work12 {
    public static void main(String[] args) {
//        work12 demo = new work12();
//        System.out.println("和是：" + demo.add(9, 34));

        System.out.println(func(160));

        return;
    }
//    如何判断一个数是否是2的k次方？这里不需要确定k的值。【不限语言】
//    示例：当n为1时：1是2的0次方 当n为4时：4是2的2次方

    //思路：因为2的k次方的数都是10000这种形式  所以先将cur设置为1 然后判断然后左移
    private static boolean func(int n) {
        int cur = 1;
        for (int i = 0; i < 32; i++) {
            if (cur == n) {
                return true;
            }
            cur <<= 1;
        }
        return false;
    }

//    public int add(int a, int b) {
//        try {
//            return a + b;
//        } catch (Exception e) {
//            System.out.println("Catch 语句块");
//        } finally {
//            System.out.println("finally 语句块");
//        }
//        return 0;
//    }
}



