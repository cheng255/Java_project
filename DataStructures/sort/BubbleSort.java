package com.atguigu.sort;

import java.time.LocalTime;



/*
 * 
 * 冒泡排序
 * 
 */

public class BubbleSort {
	
	public static void main(String[] args) {
	
//		int[] arr = new int[] {5,-1,4,8,10,4,7};
		
		//测试冒泡排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		bubbleSort(arr);
		
//		System.out.println("排序后：");
//		System.out.println(Arrays.toString(arr));
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 9.5秒
		
		
		
		
		
		
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			boolean flag = false; // 用于表示本次循环有没有交换过

			int temp = 0; // 临时变量，用作交换
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}

			// 优化
			if (!flag) { // 本此循环排序中，一次交换都没发生
				break;
			} else {
				flag = false; // 重置flag， 用于下次循环
			}

		}
		
	}
	

}
