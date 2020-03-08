package com.atguigu.exer;
/*创建Account类的一个子类CheckAccount代表可透支的账户，该账户中定义一个属性overdraft代表可透支限额
 * 在CheckAccount类中重写withdraw方法，其算法如下：
 * 
 * 	如果（取款金额<账户金额），
 * 	可直接取款
 * 	如果（取款金额>账户金额），
 * 	计算需要透支的额度
 * 	判断可透支额度overdraft是否足够支付本次透支需要，如果可以
 * 		将账户余额修改为0，冲减可透支金额
 * 	如果不可以
 * 		提示用户超过可透支额的限度
 * 
 * 
 */
public class CheckAccount extends Account{
	
	private double overdraft;
	
	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super( id, balance, annualInterestRate);
		this.overdraft = overdraft;
		
	}
	
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
		public void withdraw(double amount) {
			if(amount < getBalance()) {
//				getBalance -= amount;//错误
				//方式一
//				setBalance(getBalance() - amount);
				//方式二
				super.withdraw(amount);
				
			}else if(overdraft >= amount - getBalance()) {//透支额度+余额够消费
				
				overdraft -= (amount - getBalance());
				setBalance(0);
				
			}else {
				System.out.println("超过可透支限额！");
			}

		}
	
	
	

}
