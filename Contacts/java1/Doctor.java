package com.atguigu.java1;

public class Doctor extends Student{
	
	String major;
	
	public Doctor() {
		
	}

	public Doctor(String major) {
		
		this.major = major;
	}
	
	public void Studying() {
		System.out.println("医生会治病");
	}
	
	
	

}
