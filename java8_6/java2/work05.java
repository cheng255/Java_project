package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-26 8:51
 */
public class work05 {
    public static void main(String[] args) {
        System.out.println(findMoreNumber(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));

        System.out.println(getMaxSum(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));

    }

    //    1.找出无序数组当中，出现次数超过数组长度一半的数字。【不限语言】
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
//    输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的
//    最大值。要求时间复杂度为O(n)。【不限语言】
//    例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18
// 。

    // 分析：求以为一个数结尾的子数组的最大和
    private static int getMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println(new RuntimeException("数组不存在或长度为0").getMessage());
        }
//        assert arr != null;
        int[] sum = new int[arr.length]; // 创建一个数组，存放以每个数字结尾的子数组的和
        sum[0] = arr[0];
        int max = sum[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = (sum[i - 1] + arr[i] > arr[i]) ? sum[i - 1] + arr[i] : arr[i];
            max = sum[i] > max ? sum[i] : max;
        }
        return max;
    }
}
