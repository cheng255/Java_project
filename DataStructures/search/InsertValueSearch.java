package com.atguigu.search;
//1.差值查找算法类似于二分查找，不同的是差值查找每次从自适应的mid处开始查找
//
//2.将折半查找中的球mid索引的公式修改
//mid = (low + high) / 2  =  low + 1/2(high - low) 
//改成 mid = low + (key - a[low]) / (a[high] - a[low]) * (high - low)

public class InsertValueSearch {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		int resIndex = binarySearch(arr, 0, arr.length - 1, 2);
		System.out.println(resIndex);

	}
	
	public static int binarySearch(int[] arr, int left, int right, int findValue) {
		//不仅是优化，而且必须要有，因为公式中有findValue，防止下标越界
		if(left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
			return -1;
		}
			
		int mid = left + (findValue - arr[left]) / (arr[right] - arr[left])*(right - left);
		int midValue = arr[mid];
		
		if(findValue > midValue) {
			//向右递归
			 return binarySearch(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			//向左递归
			return binarySearch(arr, left, mid - 1, findValue);
		} else {
			return mid;
		}

	}
	
	

}
