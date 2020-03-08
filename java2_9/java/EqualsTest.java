package com.atguigu.java;

import java.util.Date;

/*
 * 
 * 
 * 面试题：== 和 equals()的区别
 * 
 * 
 * 一.==的使用
 * ==：运算符
 * 1.可以使用在基本数据变量和引用数据类型变量中
 * 2.如果比较的是基本数据类型，比较两个变量保存的数据是否相等（类型不一定相同）
 * 	  如果比较的是引用数据类型，比较两个对象的地址值是否相同，既两个引用是否指向同一个对象实体
 * 
 * 
 * 补充：使用==时，必须保证两边变量类型一致
 * 
 * 
 * 
 * 二.equals()方法的使用
 * 1.是一个方法，而非运算符
 * 2.只能适用于引用数据类型
 * 3.Object类中equals()的定义。
 * public boolean equals(Object obj) {
        return (this == obj);
    }
    说明：Object类中定义的equals方法和 == 作用相同
    
    4. 像String,Date,File, 包装类等都重写了Object类中的equals()方法。重写以后，
    比较的不是两个引用的地址是否相同，而是比较两个对象的实体内容是否相同。
    
    5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的实体内容是否相同。
    那么，需要对Object类中的equals()方法进行重写。
    重写的原则：比较两个对象的实体内容是否相同。
    
    
 */
public class EqualsTest {
	
	
	public static void main(String[] args) {
		//基本类型
		int a = 10;
		int b = 10;
		double c = 10.0;
		System.out.println(a == b);//true
		System.out.println(a == c);//true
		
		char d = 10;
		System.out.println(a == d);//true
		
		char d1 = 'A';
		char d2 = 65;
		System.out.println(d1 == d2);//true
		
		//引用类型
		
		Customer cust1 = new Customer("Tom",12);
		Customer cust2 = new Customer("Tom",12);
		System.out.println(cust1 == cust2);//false
		
		String p1 = new String("mama");
		String p2 = new String("mama");
		System.out.println(p1 == p2);//false
		System.out.println("************************");
		System.out.println(cust1.equals(cust2));//false方法重写后为true
		System.out.println(p1.equals(p2));//true
		
		
		Date date1 = new Date(2515151661L);
		Date date2 = new Date(2515151661L);
		System.out.println(date1 == date2);//false
		System.out.println(date1.equals(date2));//true
		
		
		
		
		
		
	}
	

}
