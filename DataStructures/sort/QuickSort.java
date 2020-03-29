package com.atguigu.sort;

import java.time.LocalTime;
import java.util.Arrays;

/*
 * 快速排序
 */
public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = {7,78,5,10,-57,2,50,90,299,4,0};
//		quickSort(arr,0,arr.length-1);	
//		System.out.println(Arrays.toString(arr));
		
		//测试快速排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 800000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		quickSort(arr, 0, arr.length - 1);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 0.02秒
		
	}

	public static void quickSort(int[] arr, int low, int high) {
		// low,high 为每次处理数组时的首、尾元素索引

		// 当low==high是表示该序列只有一个元素，不必排序了
		if (low >= high) {
			return;
		}
		// 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
		int i = low, j = high, base = arr[low];
		while (i < j) {
			// 右边哨兵从后向前找
			while (arr[j] >= base && i < j) {
				j--;
			}
			// 左边哨兵从前向后找
			while (arr[i] <= base && i < j) {
				i++;
			}
			if(i < j) {				
				swap(arr, i, j); // 交换元素
			}
			
		}
		swap(arr, low, j); // 基准元素与右哨兵交换

		// 递归调用，排序左子集合和右子集合
		quickSort(arr, low, j - 1);
		quickSort(arr, j + 1, high);
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	
}
