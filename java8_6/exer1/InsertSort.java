package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-21 13:44
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }


    /**
     * 思想：将全部区间分为有序和无序   每次取出无序的第一个 插入到有序区间中的适当位置
     *
     * @param arr
     *
     *     //时间复杂度：
     *     //最好：  O(n)        最坏：O(n^2)
     *
     *     //空间复杂度： O(n)
     *
     *     //具有稳定性
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //有序区间 【0，i-1】
            //无序区间【i, arr.length-1】
            int k = arr[i];//无序区间的第一个数
            int j = i - 1;
            for (; j >= 0 && k < arr[j]; j--) {
                arr[j + 1] = arr[j];//后移
            }
            //找到要插入的位置
            arr[j+1] = k;
        }
    }
}
