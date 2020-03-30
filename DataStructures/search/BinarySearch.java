package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/*
 * 二分查找（要求数组有序）
 */
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {1,5,7,9,10,10,10,15,17,20};
		
		 List<Integer> list = binarySearch(arr, 0, arr.length - 1, 9);
		 System.out.println(list);
		
	}
	
	/**
	 * 
	 * @param arr:数组
	 * @param left：左索引
	 * @param right：右索引
	 * @param findValue：要查找的值
	 * @return：将找到的数的下标放在集合中返回，如果没找到返回null
	 */
	public static List<Integer> binarySearch(int[] arr, int left, int right, int findValue) {
		
		if(left > right) {
			return null;
		}
			
		int mid = (left + right) / 2;
		int midValue = arr[mid];
		
		if(findValue > midValue) {
			//向右递归
			 return binarySearch(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			//向左递归
			return binarySearch(arr, left, mid - 1, findValue);
		} else {
			/*
			 * 找到了之后，
			 * 分别向左右两边扫描，将与该值相等的值全部加入到ArrayList中
			 */
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while(true) {//向左扫描
				if(temp < 0 || arr[temp] != findValue)
					break;
				resIndexList.add(temp--);
			}
			resIndexList.add(mid);
			temp = mid + 1;
			while(true) {//向右扫描
				if(temp > arr.length - 1 || arr[temp] != findValue)
					break;
				resIndexList.add(temp++);
			}
			
			return resIndexList;
		}

	}

}
