package com.atguigu.java;

public class OverloadExer {
	public static void main(String[] args) {
		System.out.println(1);
		OverloadExer test = new OverloadExer();
		test.mOL(2);
		test.mOL("hello");
	}
	//1.如下三个方法构成重载
	public void mOL(int i) {
		System.out.println(i * i);
		
	}
	public void mOL(int i, int j) {
		System.out.println(i * j);
		
	}
	public void mOL(String s) {
		System.out.println(s);
		
	}

	
	//2.如下的三个方法构成重载
	public int max(int i, int j) {
		return(i > j ? i : j);
		
	}
	public double max(double i, double j) {
		return (i > j) ? i : j;
	}
	public double max(double i, double j, double l) {
		double max = (i > j) ? i : j;
		return (max > l) ? max : l; 
	}
	
	
	
	

}
