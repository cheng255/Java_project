package exer1;

/**
 * @author nuonuo
 * @create 2020-10-22 21:32
 */
public class MergeSort implements MySort{


    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    /**
     * 分到自然排序完成为止（只剩一个元素） ，然后合（两个有序数组合成）
     *
     *  时间复杂度： O(n*logN)
     *  空间复杂度： O(n)
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    /*
    合并
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftIndex = left, rightIndex = mid + 1;
        int[] temp = new int[right - left + 1];// 辅助数组
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i + left] = temp[i];
        }
    }
}
