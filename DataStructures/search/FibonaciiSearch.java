package com.atguigu.search;

import java.util.Arrays;

/*
 * 斐波那契（黄金分割）查找
 * 
 * 斐波那契数列的值-1就代表着arr数组中的值，所以mid值就可以由斐波那契数列的黄金分割点-1来表示
 */
public class FibonaciiSearch {
	
	public static int maxSize = 20;
	public static void main(String[] args) {
	
		int [] arr = {1,8,10,14,89,1000,1243};
		System.out.println( fibSearch(arr, 1000) );
		

	}

	//创建一个斐波那契数列的方法
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	
	//编写斐波那契查找算法(非递归)
	public static int fibSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		int k = 0; //表示斐波那契分割数组的下标
		int mid = 0; //存放mid值
		int f[] = fib(); // 获取到斐波那契数列
		//获取到斐波那契分割数列的下标k
		while(high > f[k] - 1) {//如果斐波那契数列长度不够
			k++;
		}
		//因为f[k]的值有可能大于arr的长度，因此需要使用Arrays类，构造一个新的数组，并指向a[]
		int[] temp = Arrays.copyOf(arr, f[k]);//copyOf方法 不足的部分会用0填充
		//需要用arr数组最后的数来填充temp，防止0正好是要查找的数
		for(int i = high + 1; i < temp.length; i++) {
			temp[i] = arr[high];
		}
		
		//使用while来循环处理找到key
		while(low <= high) {
			mid = low + f[k - 1] - 1;//由 f[k] - 1  =  f[k - 1] - 1     +    f[k - 2] - k公式得到
			if(key < temp[mid]) {
				//向左查找
				high = mid - 1;
				k--;// 使左边的mid仍是黄金分割点
				//左边有f[k - 1] 个元素，所以k-1后可以继续拆分成f[k - 1] = f[k - 2] + f[k - 3]
			}else if(key > temp[mid]) {
				//向右查找
				low = mid + 1;
				k -= 2;
			} else {
				//找到
				if (mid <= high) {
					return mid;
				} else {
					return high;
				}
			}
		}
		return -1;//没找到
		
	}
	
	
	
	
	
}
