package com.atguigu.exer;

public class Person {
	
	private int age;
	private String name;
	
	//构造器
	public Person() {
		age = 18;
	}
	
	public Person(String n, int a) {
		name = n;
		age = a;
	}

	
	public void setAge(int a) {
		if(a < 0 || a > 130) {
//			throw new RuntimeException("传入的数据非法！");
			System.out.println("传入的数据非法！");
			return;
		}
			age = a;
		
	}
	public int getAge() {
		return age;
	}
//	绝对不要这样写
//	public int doAge(int a) {
//		age = a;
//		return age;
//	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	

}
