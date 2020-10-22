package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-22 18:59
 */
public class QuickSort {

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
     * 快排
     *
     *
     *
     *时间复杂度：
     * 最好   O(n*logN)    最坏  O(n^2)     平均   O(n*logN)
     *
     * 每做一次partition的时间复杂度为O(n)   做多少次和二叉树高度有关  二叉树高度一般是O(logN)
     *                                                                     最坏是O(n)
     *
     * 空间复杂度：
     *最好   O(logN)    最坏  O(n)     平均   O(logN)
     * 不具备稳定性
     *
     *
     *
     * 优化：
     * 1.小细节优化
     * 2.选择基点   ①可以随机选择
     *             ②可以三点取中
     * 3.partition过程中 相等的特殊处理
     *
     *
     *
     *
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
//        int partition = partition3(arr, left, right);
//        quickSort(arr, left, partition - 1);
//        quickSort(arr, partition + 1, right);
        int[] partition4 = partition4(arr, left, right);
        quickSort(arr, left, partition4[0]);
        quickSort(arr, partition4[1], right);
    }
    /**
     *
     * partition优化版本
     * 將arr中比arr[k]小的放在k左边 比arr[k]大的放在k右边  相等的放中间
     *
     * @param arr
     * @return
     */
    private static int[] partition4(int[] arr, int left, int right) {
        int base = arr[right]; //用于比较的基数
        int more = right + 1, less = left - 1;//大于base和小于base的区间边界
        while (left < more) {
            if (arr[left] > base) { //注意!  当前数比base大时  交换回来的数要重新判断
                swap(arr, --more, left);
            } else if (arr[left] < base) {
                swap(arr, ++less, left++);
            } else {
                left++;
            }
        }
        return new int[]{less, more};
    }

    /**
     * 方法一：hover法   先从右往左找到一个比基数小的数，  再从左往右找到一个比基数大的数
     *
     * @param arr   然后交换        然后继续找
     * @param left  最后交换right指针和基数指针所指的数
     * @param right 注意！   当取第一个数为基数时，一定要先从右找
     * @return
     */
    private static int partition1(int[] arr, int left, int right) {
        int base = left; //用于比较的基数
        while (left < right) {
            while (left < right && arr[right] >= arr[base]) {
                right--;
            }
            while (left < right && arr[left] <= arr[base]) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, base, right);
        return right;
    }

    /**
     * 方法二：挖坑法   hover法优化版
     *
     * @param arr
     * @param left
     * @param right 注意！   当取第一个数为基数时，一定要先从右找
     * @return
     */
    private static int partition2(int[] arr, int left, int right) {
        int base = arr[left]; //1.先把用于比较的基数挖出来
        while (left < right) {
            //2.从右向左找小于base的数填入坑
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[left] = arr[right];
            //2.从左向右找大于base的数填入坑
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }
        //4.最后将base填入坑
        arr[right] = base;

        return right;
    }

    /**
     * 方法三：前后下标法
     *
     * 思路：前后两个下标范围内表示比基数大于等于的数
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition3(int[] arr, int left, int right) {
        int separateIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            // 1.当遇到比基数小的数才做处理  处理方法为
            // 把separateIndex和当前数交换，然后separateIndex++
            if (arr[i] < arr[left]) {
                swap(arr, separateIndex, i);
                separateIndex++;
            }
        }
        //最后再把基数和separateIndex - 1下标元素交换
        swap(arr, separateIndex - 1, left);
        return separateIndex - 1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
