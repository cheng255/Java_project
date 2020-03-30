package com.atguigu.sort;

import java.time.LocalTime;
import java.util.Arrays;

/*
 * 归并排序
 * 
 */
public class MergeSort {
	public static void main(String[] args) {
//		int arr[] = {8,4,5,7,1,3,6,2};
//		int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
//		mergeSort(arr, 0, arr.length - 1, temp);
//		System.out.println(Arrays.toString(arr));
		
		//测试归并排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
		mergeSort(arr,0, arr.length - 1, temp);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 0.02秒
		
		
	}
	
	//分+合的方法
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if(left < right) {
			int mid = (left + right) / 2;//中间索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid+1, right, temp);
			
			//合并
			merge(arr, left, mid, right, temp);
			
		}
	}
	
	
	/**
	 * 
	 * @param arr 排序的原始数组
	 * @param left 左边有序序列的出事索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param temp 做中转的数组
	 */
	//合并的方法
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		
		int i = left;//初始化i，表示左边有序序列的初始索引
		int j = mid + 1; // 初始化j，表示右边有序序列的初始索引
		int t = 0; //指向temp数组的当前索引
		
		//1.
		//先把左右两边（有序）的数据按照规则填充到temp数组
		//直到左右两边有一边处理完毕
		while(i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
			
		}
		
		//2.
		//把剩余的数据全部填充到temp
		while(i <= mid) {//左边剩余
			temp[t++] = arr[i++];
		}
		while(j <= right) {//右边剩余
			temp[t++] = arr[j++];
		}
		
		//3.
		//将temp数组的元素拷贝到arr
		//并不是每次都拷贝全部
		t = 0;
		int tempLeft = left; // 
		while(tempLeft <= right) { // 第一次合并时tempLeft为0； right为1  第二次： tempLeft为2，right为3
			//最后一次合并tempLeft为0，right为7
			arr[tempLeft++] = temp[t++];
			
		}
		
		
		
		
		
	}

}
