package com.atguigu.sort;

import java.time.LocalTime;
import java.util.Arrays;

/*
 * 
 * 堆排序：
 * 	思想：
 * 		1.将待排序的序列构成一个大顶堆
 * 		2.此时，整个序列的最大值就是堆顶的根节点
 * 		3.将其与末尾元素进行交换，此时末尾就是最大值
 * 		4.然后将剩余的n-1个元素重新构造成一个堆，这样会得到次小值。
 * 		    如此反复执行，便能得到一个有序序列
 * 
 * 
 */
public class HeapSort {
	public static void main(String[] args) {
		//升序 ==> 使用大顶堆
//		int arr[] = {4,6,8,5,9,-2,90,-5,900,-40};
//		heapSort(arr);
//		System.out.println(Arrays.toString(arr));
		
		//测试堆排序的速度o(n^2),给80000个数据，测试
		int[] arr = new int[8000000];
		for(int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 80000000);//生成[0 - 80000000) 的随机数
		}
		LocalTime startTime = LocalTime.now();
		System.out.println("排序前的时间" + startTime);
		
		heapSort(arr);
		
		LocalTime endTime = LocalTime.now();
		System.out.println("排序后的时间" + endTime);
		
		// 0.02秒
		
	}
	
	
	//编写堆排序方法
	public static void heapSort(int[] arr) {
		int temp = 0;//用做交换
		
		for(int i = arr.length / 2 - 1; i >= 0; i--) {//arr.length / 2 - 1表示非叶子结点的个数
			adjustHeap(arr, i, arr.length);
		}
		
		for(int j = arr.length - 1; j > 0; j--) {
			//交换
			temp = arr[j];
			arr[j] = arr[0];//将最大值（root结点值）放到数组最后
			arr[0] = temp;
			adjustHeap(arr, 0, j);//0是因为将末尾数换到树顶来，他必然不是最大的，也必然需要调整
									//而且因为第一次调整将其余的非叶子结点都调整好了，所以只需要
									//调整下标为0的值。
		}

	}
	
	
	

	/**
	 * 将一个数组（二叉树）调整成一个大顶堆
	 * 
	 * 功能：完成将i对应的非叶子结点的树调整成大顶堆
 	 * @param arr:待调整的数组
	 * @param i：表示非叶子结点在数组中的索引
	 * @param len：表示对多少个元素进行调整， len是在逐渐减少
	 */
	public static void adjustHeap(int arr[], int i, int len) {
		
		int temp = arr[i]; //先取出当前元素的值保存
		
		//k = i * 2 + 1 是 i结点的左子结点
		for(int k = i * 2 + 1; k < len; k = k * 2 + 1) {
			//获取较大的子节点
			if(k + 1 < len && arr[k] < arr[k + 1]) { // 说明左子结点的值小于右子节点的值
				k++; //k 就指向右子节点
			}
			if(arr[k] > temp) { // 如果该子节点大于父节点
				arr[i] = arr[k]; // 把较大的值赋给当前结点
				i = k;// i 指向 k ,则可以继续比较
			} else {
				break;
			}
			
		}
		//for循环结束后，已经完成以i为父节点的数的最大值，放在了最顶上（局部）
		//还要调整其他的非叶子结点。
		
		arr[i] = temp;//将temp值赋值给调整后的位置
	}
	
	
	
	

}
