package com.atguigu.java1;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void eat() {
		System.out.println("人会吃饭");
		
	}
	public void sleep() {
		System.out.println("人会睡觉");
		
	}
	
}
