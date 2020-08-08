package com.atguigu.exer;
/*
 * 写一个名为Account的类模拟账户。该类包括的属性：账号id，余额balance,年利率annualInterestRate
 * 包括的方法：访问器方法（getter和setter方法），返回月利率的方法getMonthlyInterest()，取款方法
 * deposit().
 */
public class Account {
	
	private int id;//账号
	private double balance;//余额
	private double annualInterestRate;//年利率


	public Account() {
		
	}
	public Account(int id, double balance, double annualInterestRate) {
		
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	
	
	public double getMonthlyInterest() {
		return annualInterestRate/12;
	}
	//取钱
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return;
		}
		System.out.println("余额不足");
	}
	//存钱
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			return;
		}
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
}
