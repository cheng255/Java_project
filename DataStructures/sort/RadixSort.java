package com.atguigu.sort;

import java.time.LocalTime;
import java.util.Arrays;

/*
 * 基数排序
 * 
 */
public class RadixSort {

	public static void main(String[] args) {
//		int arr[] = {50, 12, 730, 206, 522, 14};
//		radixSort(arr);
//		System.out.println(Arrays.toString(arr));
		
		//测试插入排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		radixSort(arr);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 0.02秒
		
	}
	
	//基数排序方法
	private static void radixSort(int[] arr) {
		
		
		//定义一个二维数组，表示十个桶，每个桶就是一个一维数组
		// 为了防止在放入数的时候数据溢出，则每个一维数组的大小只能定为arr.length
		//基数排序时空间换时间
		int[][] bucket = new int[10][arr.length];
		
		//为了记录每个桶中实际存放了多少个数据，定义一个一维数组来记录各个桶每次放入的数据个数
		//bucketElementCounts[0] 就是bucket[0] 桶中存放数据的个数
		int[] bucketElementCounts = new int[10];
		
		
		//1.得到数组中最大的数的位数
		int max = arr[0];//最大的数
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		//得到最大数是几位数
		int maxLength = (max + "").length();
	
		//针对每个元素的相应位来进行排序处理，第一次个位，第二次十位，以此类推
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
	
			// 每一轮
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素的对应的位
				int digitOfElement = arr[j] / n % 10;
				// 放入到对应的桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// 按照这个桶的顺序一次取出数据，放入原来的数组中
			int index = 0;
			// 遍历每天一个桶，并将桶中的数据放入到原数组
			for (int k = 0; k < bucket.length; k++) {
				// 如果桶中有数据，才将数据放入到原数组
				if (bucketElementCounts[k] != 0) {// 桶中有数据
					// 循环该桶
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// 取出元素放入到元素中
						arr[index++] = bucket[k][l];
					}
				}
				// 重置：
				// 每轮结束，需要将每个bucketElementCounts[k] = 0
				bucketElementCounts[k] = 0;
			}
		}
		

			
		
	}
	
	
}
