package com.cheng.exer2;

import java.util.Arrays;

/**
 *
 *
 * @author nuonuo
 * @create 2020-10-22 21:13
 */
public class partitionTest {

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        oddLeftEvenRight(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    //将奇数放在左边，偶数放在右边
    private static void oddLeftEvenRight(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && (arr[right] & 1) == 1) {
                right--;
            }
            while (left < right && (arr[left] & 1) == 0) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
