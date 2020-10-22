package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-21 23:17
 */
public class HeapSort {
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
     * 算法思路：先建立一个大根堆，然后每次将数组最后的元素和堆顶元素A交换，然后A即为有序区间的一位，
     * 然后需要一次向下调整，然后继续交换数组最后的元素和堆顶元素A
     *
     * 时间复杂度： O(n logN)
     * 空间复杂度: O(1)
     *
     * 不具备稳定性
     * @param arr
     */
    private static void sort(int[] arr) {
        //1.建立大根堆
        createHeap(arr, arr.length);
        int size = arr.length; // 表示无序区间的大小
        while (size > 0) {
            int temp = arr[0]; arr[0] = arr[size - 1]; arr[size - 1] = temp; //2.将数组最后的元素和堆顶元素交换
            adjustDown(arr, 0, --size);
        }

    }

    /**
     * 建立大根堆
     *
     * @param arr
     */
    private static void createHeap(int[] arr, int size) {
        //将所有非叶子结点进行向下调整  非叶子结点的区间为【0，(size-2)/2】
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustDown(arr, i, size);
        }
    }

    /**
     * 向下调整
     *
     * @param arr
     * @param i
     */
    private static void adjustDown(int[] arr, int i, int size) {
        //当需要调整的数不存在或者没有孩子时，直接返回
        while (i * 2 + 1 < size) {
            //选出左右孩子中较大的一个
            int max = i * 2 + 1;
            if (i * 2 + 2 >= size || arr[i * 2 + 2] > arr[i * 2 + 1]) {
                max += 1;
            }
            if (arr[i] > arr[max]) {
                return;
            }
            //到这表示需要向下置换
            int temp = arr[i]; arr[i] = arr[max]; arr[max] = temp;
            i = max;
        }
    }
}
