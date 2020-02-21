package com.atguigu.java1;

import org.junit.Test;

/*
 * 
 * 包装类的使用
 * 1.JAVA提供了8中基本数据类型的包装类，使得基本数据类型的变量具有类的特征
 * 
 * 2.掌握的   ： 基本数据类型，包装类， String三者之间的互相转换
 * 
 * 
 */
public class WrapperTest {
	
	
	
	
	
	//基本数据类型---->>包装类: 调用包装类的构造器
	@Test
	public void test1() {
		
		int num1 = 10;
		Integer in1 = new Integer(num1);
		System.out.println(in1.toString());
		
		Integer in2 = new Integer("123");
		System.out.println(in2.toString());
		
		
		//报异常
//		Integer in3 = new Integer("abc");
//		System.out.println(in3.toString());
		
		Float f1 = new Float(12.3);
		Float f2 = new Float("12.3");
		System.out.println(f1);//true
		System.out.println(f2);//true
		
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean("true");
		Boolean b3 = new Boolean("tRue");
		Boolean b4 = new Boolean("true123");
		System.out.println(b1);//true
		System.out.println(b2);//true
		System.out.println(b3);//true
		System.out.println(b4);//false
		
		Order order = new Order();
		System.out.println(order.isMale);//false
		System.out.println(order.isFemale);//null
		
		
	}
	
	//包装类--->>>基本数据类型: 调用包装类的xxxValue()
	@Test
	public void test2() {
		
		Integer in1 = new Integer(12);
		
		int i1 = in1.intValue();
		System.out.println(i1 + 1);
		
		Float f1 = new Float(12.3);
		
		float f2 = f1.floatValue();
		System.out.println(f2+4);
		
		
	}
	
	@Test
	
	public void test3() {
//		int num1 = 10;
//		
//		//基本数据类型-->>包装类的对象
//		method(num1);
		
		//自动装箱
		int num2 = 10;
		Integer in1 = num2;//自动装箱
		
		boolean b1 = true;
		Boolean b2 = b1;//自动装箱
		
		//包装类的对象-->>基本数据类型
		
		System.out.println(in1.toString());
		int num3 = in1;//自动拆箱
		System.out.println(num3);
		
	}
	
	public void method(Object obj) {
		
		System.out.println(obj);
	}
	
	//基本数据类型，包装类-->>String类型：调用String重载的valueOf(Xxx xxx)
	@Test
	public void test4() {
		
		int num1 = 10;
		//方式一
		String str1 = num1 + "";
		//方式二
		float f1 = 12.3f;
		String str2 = String.valueOf(f1);
		System.out.println(str2);
		
		Double d1 = new Double(12.4);
		String str3 = String.valueOf(d1);
		
		System.out.println(str3);
	}
	
	//String类型-->>基本数据类型，包装类： 调用包装类的parseXxx()
	@Test
	public void test5() {
		String str1 = "123";
//		int num1 = (int)str1;//错误
//		Integer in1 = (Integer)str1;//错误 
		
		int num2 = Integer.parseInt(str1);
		System.out.println(num2 +1);
		
		String str2 = "true";
		boolean b1 = Boolean.valueOf(str2);
		Boolean b2 = Boolean.valueOf(str2);
		System.out.println(b1);
		System.out.println(b2);
	}
	
	
	
	

}


class Order{
	
	boolean isMale;
	Boolean isFemale;
	
	
}
