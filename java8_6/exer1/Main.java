package exer1;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-10-28 13:54
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        MySort mysort = new HeapSort();
        System.out.println(Arrays.toString(arr));
        mysort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
