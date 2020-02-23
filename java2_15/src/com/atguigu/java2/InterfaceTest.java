package com.atguigu.java2;

/*
 * 
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.JAVA中，接口和类式并列的两个结构
 * 3.如何定义接口，定义接口中的成员
 * 
 * 
 * 		3.1 JDK7及以前，只能定义全局变量和抽象方法
 * 			>>全局常量：public static final的，但是可以省略不写
 * 			>>抽象方法：public abstact的
 * 
 * 		3.2 JDK8：还可以定义静态方法，默认方法
 * 
 * 4.接口中不能定义构造器，意味着借口不可以实例化
 * 
 * 5.java开发当中，接口通过让类去实现(implements)的方式来使用
 * 	如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 * 	如果实现类没有覆盖了接口中的所有抽象方法，则此实现类仍未抽象类
 * 
 * 6.java类可以实现多个接口---->弥补了java单继承性的局限性
 * 
 * 格式：class AA extends BB implements CC,DD,EE
 * 
 * 7.接口与接口之间可以多继承
 * 
 * 8.接口的具体使用，体现多态性
 * 9.接口，实际上可以看作是一种规范
 * 
 * 
 */

public class InterfaceTest {

	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);
		System.out.println(Flyable.MIN_SPEED);
		
		Plane plane = new Plane();
		Helicopter he = new Helicopter();
		System.out.println(he.MAX_SPEED);
//		Flyable.MIN_SPEED = 2;
	}
}


interface Flyable{
	
	//全局常量
	public static final int MAX_SPEED = 7900;//第一宇宙速度
	int MIN_SPEED = 1;//省略了public static final
	
	void fly();//省略了public abstact
	
}


class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("飞机通过引擎飞行");
		
	}
	public void stop() {
		System.out.println("飞行员控制停止");
	}
	
	
}

class Helicopter extends Plane {
	
	
}













