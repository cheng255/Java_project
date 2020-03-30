package com.atguigu.search;
/*
 * 顺序查找
 */
public class SeqSeqrch {

	public static void main(String[] args) {
		int arr[] = {1,6,2,10,7,4};
		int index = seqSearch(arr, 4);
		if(index == -1) {
			System.out.println("没有找到");
		} else {
			System.out.println("找到了");
		}
		
	}
	
	//这里实现得是只找一个值，也可以用数组找多个
	public static int seqSearch(int[] arr, int value) {
		//线性查找是逐一比对，发现相同值就返回下标
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	
}
