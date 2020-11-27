package com.cheng.exer1;

import java.util.Arrays;

/**
 * 找出第k大的数
 * @author nuonuo
 * @create 2020-11-24 0:37
 */
public class T2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,2};
        int i = findKth(a, 5, 3);
        System.out.println(i);
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here
        //首先进行一次partition
        //然后判断第k大的数是在三个区间中的哪一个
        //然后再对相应区间进行partition
        int[] p = partition(a, 0, n - 1);//默认根据left位置数据进行划分
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(p));
        if (K > (n - p[0])) {
            //表示在小于的区间
            int[] newa = Arrays.copyOfRange(a,0,p[0]);
            return findKth(newa, p[0], K-(n - p[0]));
        } else if (K < (n - p[1])) {
            //表示在大于的区间
            int[] newa = Arrays.copyOfRange(a,p[1]+1,n);
            return findKth(newa, n - p[1] - 1, K);
        } else {
            //表示在等于的区间
            return a[p[0]];
        }
    }
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while(L < more) {
            if(arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            }else if(arr[L] > arr[R]) {
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
