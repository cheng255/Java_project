package com.atguigu.java;

/*
 * 1.static：静态的
 * 2.static可以修饰：属性，方法，代码块，内部类
 * 
 * 3.使用static修饰属性
 * 	
 * 		3.1
 * 			静态变量： 多个对象共用一个静态属性
 * 			实例变量： 每个对象独立拥有一个非静态属性
 *
 *		3.2 static修饰属性的其他说明
 *			① 静态变量随着类的加载而加载
 *			② 静态变量的加载要早于对象的创建
 *			③ 由于类只执行一次，所以静态变量在内存中也只会存在一份，存在方法区的静态域中
 *		3.3 静态属性举例 ：System.out 		 
 * 
 * 4.使用static修饰方法
 * 			
 * 		静态方法中只能调用静态方法和属性
 * 		
 * 		非静态方法中，既......又......（生命周期）
 * 5. static注意点：
 * 在静态方法内，不能使用super，this关键字 
 * 
 */
public class StaticTest {

	public static void main(String[] args) {
		
		Chinese.nation = "中国";
		
		Chinese c1 = new Chinese();
		c1.name = "姚明";
		c1.age = 40;
		
		
		Chinese c2 = new Chinese();
		c2.name = "马龙";
		c2.age = 30;
		
//		c1.nation = "China";
		System.out.println(c2.nation);
		c2.nation = "CHINA";
		System.out.println(c1.nation);
		    
		Chinese.work();
	}
}

//中国人
class Chinese{
	
	
	String name;
	int age;
	
	static String nation;
	
	static void work() {
		System.out.println("人会工作");
		
//		name = "TOM";
		
	}
}
