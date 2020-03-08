package com.atguigu.java;

/*
 * 
 * final:最终的
 * 
 * 1. final可以用来修饰的结构：类 方法 变量
 * 
 * 2.final 用来修饰一个类:此类不能被其他类继承
 * 			比如：String类，System类，StringBuffer类
 * 
 * 3.final修饰方法，表明此方法不能被重写
 * 			比如：Object类中getClass();
 * 
 * 4.final 用来修饰变量：此时的变量就成为是一个常量
 * 			4.1 final修饰属性：可以考虑赋值的位置有：显示初始化，代码块中初始化，构造器中初始化
 * 
 * 
 * 
 * 
 */
public class FinalTest {
	public final void sleep() {
		System.out.println("1111");
	}
}



final class FinalA{
	
}
//class B extends FinalA{
//	
//}
//class B extends String{
//	
//}















