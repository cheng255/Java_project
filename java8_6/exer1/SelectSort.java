package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-21 14:15
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路 ：每一轮从无序区间选出一个最小的数，与无序区间的第一个交换
     *
     *
     * 时间复杂度：
     * 最好最坏：O(n^2)
     *
     * 具备稳定性
     * @param arr
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j <arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) { // 选出的最小值不是初始值时 将最小值交换到前面
                int temp = arr[min]; arr[min] = arr[i]; arr[i] = temp;
            }
        }
    }
}
