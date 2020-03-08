package com.atguigu.exer;
/*
 * 创建一个账号为1122，余额为20000，年利率为4.5%，可透支额为5000元的Account对象
* 使用withdraw方法提款5000元，并打印账户余额和可透支额。
* 再使用withdraw方法提款18000元。并打印账户余额和可透支额
* 使用withdraw方法存款3000元，然后打印账户余额和可透支额。
*/
public class CheckAccountTest {
	public static void main(String[] args) {
		
		CheckAccount cacct = new CheckAccount(1122,20000,0.045,5000);
	
		cacct.withdraw(5000);
		System.out.println("账户余额为：" + cacct.getBalance() + ",\n 可透支额为：" + cacct.getOverdraft());
		cacct.withdraw(18000);
		System.out.println("账户余额为：" + cacct.getBalance() + ",\n 可透支额为：" + cacct.getOverdraft());
		cacct.withdraw(3000);
		System.out.println("账户余额为：" + cacct.getBalance() + ",\n 可透支额为：" + cacct.getOverdraft());
		
		
	}

}
