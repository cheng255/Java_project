package com.atguigu.exer3;

/*
 * 定义Kids继承ManKind，并包括
 * 成员变量int yearsOld;
 * 方法printAge()打印yearsOld的值
 */
public class Kids extends ManKind{
	
	int yearsOld;
	
	public Kids(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	public Kids(int sex, int salary, int yearsOld) {
		super(sex,salary);
		this.yearsOld = yearsOld;
	}
	

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	public void printAge() {
		System.out.println(yearsOld);
	}
	
	

}
