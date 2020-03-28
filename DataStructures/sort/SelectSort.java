package com.atguigu.sort;
/*
 * 选择排序
 */
import java.time.LocalTime;

public class SelectSort {

	public static void main(String[] args) {
		
		//测试选择排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		selectSort(arr);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 2.5秒
	}
	
	
	private static void selectSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			int minIndex = i; // 先假定当前这个数是最小的数 , minIndex为假定最小值的下标
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				
			}
			
		}
		
	}
	
}



