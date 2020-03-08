package com.atguigu.java;
/*
 * 可变个数形参的方法
 * 
 * 1.jdk 5.0新增的内容
 * 2.具体使用：
 * 	2.1 可变个数形参的格式 数据类型 ... 变量名
 * 	2.2 当调用可变个数形参的方法时，传入的参数个数可以是0,1,2...个
 * 	2.3 可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
 *  2.4可变个数形参的方法与本类中方法名相同，形参也相同的方法之间不构成重载，不能共存
 *  2.5可变个数形参在方法的形参中，必须声明在末尾
 *  2.6可变个数形参在方法的形参中，最多只能声明一个可变形参
 */
public class MethodArgsTest {
	
	public static void main(String[] args) {
		MethodArgsTest test = new MethodArgsTest();
		test.show(12);
		test.show("hello");
		test.show("hello","world");
		test.show();
		
//		test.show(new String[] {"AA","BB"});
//		
	}
	
	public void show(int i) {
		
		
	}
//	public void show(String s) {
//		System.out.println("show(String)");
//	}
	
	
	public void show(String ... strs) {
		System.out.println("show(String ... strs)");
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
	
//	public void show(String[] strs) {
//		
//	}
//	The variable argument type Sring of the method show must be the last parameter
//	public void show(Sring ... strs, int i) {
//		
//	}

}
