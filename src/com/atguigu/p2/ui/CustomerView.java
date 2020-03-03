package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author 86182
 *
 */

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	public CustomerView() {
		Customer customer = new Customer("妞妞", '女', 23, "123456789", "wt@gmail.com");
		customerList.addCustomer(customer);
		
	}
	
	/**
	 * 显示《客户信息管理软件》界面的方法
	 */
	public void enterMainMenu() {
		
		
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("\n--------------------客户信息管理软件--------------------");
			System.out.println("                      1 添加客户");
			System.out.println("                      2 修改客户");
			System.out.println("                      3 删除客户");
			System.out.println("                      4 客户列表");
			System.out.println("                      5 退    出\n");
			System.out.print("                      请选择(1-5):");
			
			char menu = CMUtility.readMenuSelection();
			switch(menu) {
			case '1':
				addNewCustomer();
				break;
				
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
//				System.out.println("退出");
				System.out.println("确认是否退出(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if(isExit == 'Y') {
					isFlag = false;
					
				}
//				break;
				
			}
			
		}
		
	
	}
	/**
	 * 添加客户的操作
	 */
	public void addNewCustomer() {
//		System.out.println("添加客户的操作");
		System.out.println("--------------------添加客户--------------------");
		
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);
		
		//将上述数据封装到对象中
		Customer customer = new Customer(name, gender, age, phone, email);
		
		boolean isSuccess = customerList.addCustomer(customer);
		if(isSuccess) {
			System.out.println("--------------------------添加成功--------------------------");
		}else {
			System.out.println("--------------------客户目录已满，添加失败--------------------");
		}
		
		
	}
	/**
	 * 修改客户的操作
	 * @param  
	 */
	public void modifyCustomer() {
//		修改客户的操作
		System.out.println("--------------------修改客户--------------------");
		Customer cust;
		int number;
		for(; ;) {
					
			System.out.print("请选择待修改客户编号(-1退出):");
			number = CMUtility.readInt();
			
			if(number == -1) {
				return;
			}
			
			cust = customerList.getCustomer(number - 1);
			if(cust == null) {
				System.out.println("无法找到指定客户！");
				
			}else {//找到了相应编号的客户   
				break;//跳到修改客户信息
			}
				
		}
		//修改客户信息
		System.out.println("姓名(" + cust.getName() + "):" );
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("性别(" + cust.getGender() + "):" );
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄(" + cust.getName() + "):" );
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话(" + cust.getName() + "):" );
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.println("邮箱(" + cust.getName() + "):" );
		String email = CMUtility.readString(30, cust.getEmail());
		//1只改变属性值
//		cust.setName(name);
//		cust.setGender(gender);
//		cust.setAge(age);
//		cust.setPhone(phone);
//		cust.setEmail(email);
		//2new了一个数组
		Customer newCust = new Customer(name, gender, age, phone, email);
		
		boolean isRepalaced = customerList.replaceCustomer(number - 1, newCust);
		if(isRepalaced) {
			System.out.println("--------------------修改完成--------------------");
		}else {
			System.out.println("--------------------修改失败--------------------");
		}
			
	}
	/**
	 * 删除客户的操作
	 */
	public void deleteCustomer() {
//		System.out.println("删除客户的操作");
		int number;
		System.out.println("--------------------删除客户--------------------");
		
		System.out.print("请选择待修改客户编号(-1退出):");
		
		for(;;) {
			number = CMUtility.readInt();
			
			if(number == -1) {
				return;
			}
			 
			Customer customer = customerList.getCustomer(number - 1);
			if(customer == null) {
				System.out.println("无法找到客户！");
				
			}else {
				break;
			}
			
		}
		
		//找到了指定的客户
		System.out.println("确认是否删除(Y/N)");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete == 'Y') {
			boolean isDeleteSuccess = customerList.deleteCustomer(number - 1);
			if(isDeleteSuccess) {
				System.out.println("--------------------删除成功--------------------");
			}else {
				System.out.println("--------------------删除失败--------------------");
			}
					
		}else {
			return;
		}
		
	}
	/**
	 * 显示客户列表的操作
	 */
	public void listAllCustomers() {
//		System.out.println("显示客户的操作");
		System.out.println("--------------------客户列表--------------------");
		
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("没有客户记录！");
			
		}else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for(int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" +
				cust.getGender() + "\t"+ cust.getAge() + 
				"\t" + cust.getPhone() + "\t" + cust.getEmail());
			}
		}
		
		System.out.println("--------------------客户列表完成--------------------");
		
	}
	
	
	public static void main(String[] args) {
		
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}

	
	
}
