package com.atguigu.sort;

import java.time.LocalTime;
//import java.util.Arrays;

/*
 * 插入排序
 */
public class InsertSort {
	public static void main(String[] args) {
		
//		int[] arr = new int[] {5,-1,7,2,1};	
//		insertSort(arr);	
//		System.out.println(Arrays.toString(arr));
		
		//测试插入排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[80000];
		for(int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		insertSort(arr);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 2秒
		
		
		

	}
	
	private static void insertSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) { // 从下标为1的数开始，依次找合适的位置插入。
			
			//保存待插入的数
			int insertVal = arr[i];
			int insertIndex = i - 1;//保存arr[i]前面的这个数的下标
			
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//说明arr[i]还没有找到待插入位置
				arr[insertIndex + 1] = arr[insertIndex];//将该位置的数往后移
				insertIndex--;
			}
			

			arr[insertIndex + 1] = insertVal;//将当前数插入
			
			
		}
		
		
	}

}
