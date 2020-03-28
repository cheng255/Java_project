package com.atguigu.sort;

import java.time.LocalTime;
import java.util.Arrays;

/*
 * 希尔排序
 */
public class ShellSort {

	public static void main(String[] args) {
		
//		int[] arr = new int[] {3,-1,9,4,3,7,10,-6,5,2};
//		shellSort(arr);
		
		//测试插入排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		shellSort(arr);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 0.02秒
		
	}
	private static void shellSort(int[] arr) {
		
//		int count = 0;
		for(int gap = arr.length / 2; gap > 0; gap /= 2) {
			//从第gap个元素开始，逐个对其所在的组进行直接插入排序
			for(int i = gap; i < arr.length; i++) { // 此时跟i所对应的正好就是本组第一个数，即下标为0的数
				int j = i;//记录待插入的值的下标
				int temp = arr[j]; //记录待插入的数
				if(arr[j] < arr[j - gap]) {
					while(j - gap >= 0 && temp  < arr[j - gap]) {
						arr[j] = arr[j - gap];//移动
						j -= gap;
					}
					//当退出while时，就找到了插入位置，
					arr[j] = temp;
				}
				
			}
//			System.out.println("希尔排序第" + (++count) + "轮后：" + Arrays.toString(arr));
			
		}
		

		
	}
	
	
}
