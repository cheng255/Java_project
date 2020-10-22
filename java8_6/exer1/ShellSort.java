package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-22 9:12
 */
public class ShellSort {


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
     * 算法思想：（分组插入排序）
     * 时间复杂度：
     * 最坏：O(n^2)  最好： O(n)   平均： O(n^1.3)
     * 空间复杂度：O(1)
     *
     * 不具备稳定性
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        //1.先将数组分为arr.length / 2 组， 组内进行插入排序
        int k = arr.length / 2;
        while (k > 0) {
//            for (int i = 0; i < k; i++) {
////                insert(arr, i, k);
////            }
            insert1(arr, k);
            k /= 2;
        }


    }
    /*
        也可以理解为是从k位置到后面所有的数都要进行各自的插入
     */
    private static void insert1(int[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            int n = arr[i]; // 要插入的数
            int j;
            for (j = i - k; j >= 0 && arr[j] > n; j -= k) {
                arr[j + k] = arr[j]; //大于要插入的数就往后移
            }
            arr[j + k] = n;
        }
    }

    /*
     * 简单插入排序
     *
     */
    private static void insert(int[] arr, int i, int k) {
//        for (i = i + k; i < arr.length; i += k) {   这段为啥有问题
//            int n = arr[i]; // 要插入的数
//            for (int j = i - k; j >= 0; j -= k) {
//                if (arr[j] > n) {
//                    arr[j + k] = arr[j]; //大于要插入的数就往后移
//                    continue;
//                }
//                arr[j + k] = n;
//                break;
//            }
//        }
        for (i = i + k; i < arr.length; i += k) {
            int n = arr[i]; // 要插入的数
            int j;
            for (j = i - k; j >= 0 && arr[j] > n; j -= k) {
                arr[j + k] = arr[j]; //大于要插入的数就往后移
            }
            arr[j + k] = n;
        }
    }
}
