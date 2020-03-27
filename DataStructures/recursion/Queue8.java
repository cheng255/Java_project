package com.atguigu.recursion;

public class Queue8 {

	//定义一个max表示共有多少皇后
	int max = 8;
	int []arr = new int[max];
	int num = 0;
	static int count = 0;
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		
		queue8.check(0);
		System.out.println("共有" + count + "种解法");
		
		
		
	}
	//编写一个方法，放置第n个皇后
	//注意：每一层递归都有一个for循环
	private void check(int n) {
		if(n == max) { // n == 8
			print();
			return;
		}
		//依次放入皇后,并判断是否冲突
		for(int i = 0; i < max; i++) {
			//先把当前皇后n放到该行的第一列
			arr[n] = i;
			//判断当放置第n个皇后到i列时是否和前面的位置冲突
			if(judge(n)) { // 不冲突
				//接着放第n+1个皇后，既开始递归
				check(n+1);
			}
			// 如果冲突，九局徐执行arr[n] = i;既将第n个皇后在本行后移
			
		}
	}
	
	
	//写一个方法，判断该皇后是否和前面的皇后位置冲突
	/**
	 * 
	 * @param n:表示第n个皇后
	 * @return
	 */
	private boolean judge (int n) {
		for(int i = 0; i < n; i++) {
			if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	//写一个方法，可以将皇后摆放的位置输出
	
	private void print () {
		count++;
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
	
	
	

	
}
