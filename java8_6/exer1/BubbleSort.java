package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-21 14:06
 */
public class BubbleSort {

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
     * 算法思想：一共比较n-1轮 每一轮通过相邻一对一比较的方式，将最大的元素交换到最后
     *
     * @param arr
     *
     *     //时间复杂度：
     *    //最好：  O(n)        最坏：O(n^2)
     *
     *     //空间复杂度： O(n)
     *     //具有稳定性
     *
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//假设已经有序
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }

    }
}
