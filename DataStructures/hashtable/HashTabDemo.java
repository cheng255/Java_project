package com.atguigu.hashtable;

import java.util.Scanner;

public class HashTabDemo {
	public static void main(String[] args) {
		
		//创建哈希表
		HashTab hashTab = new HashTab(7);
		
		//写一个菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("exit:退出系统");
			System.out.println("find:查找雇员");
			System.out.println("delete:删除雇员");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入id：");
				int id = scanner.nextInt();
				System.out.println("输入名字：");
				String name = scanner.next();
				//创建雇员
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("输入要查找的雇员id");
				id = scanner.nextInt();
				hashTab.findEmpById(id);
				break;
			case "delete":
				System.out.println("输入要删除的雇员id");
				id = scanner.nextInt();
				hashTab.deleteById(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
			
		}
		
	}
	
	
	
}

//创建HashTab 管理多条链表
class HashTab {
	private EmpLinkedList[] empLinkedListArray;
	private int size;//表示共有多少链表，既数组长度
	//构造器
	public HashTab(int size) {//初始化数组
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		//分别初始化每一条链表
		for(int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	//添加雇员
	public void add(Emp emp) {
		//根据员工的id 得到该员工应该加入到那条链表
		int empLinkedListNO = hashFun(emp.id);
		//根据empLinkedListNO 将emp 添加到对应的链表中
		empLinkedListArray[empLinkedListNO].add(emp);
	}
	//遍历hashTab
	public void list() {
		for(int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	//查找雇员
	public void findEmpById(int id) {
		int empLinkedListNO = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNO].find(id);
		if(emp != null) {
			System.out.println("找到了，雇员信息为：" + emp.toString());
		}else {
			System.out.println("在哈希表中，没有找到该雇员");
		}
	}
	//删除雇员
	public void deleteById(int id) {
		int empLinkedListNO = hashFun(id);
		empLinkedListArray[empLinkedListNO].delete(id);
	}
	
	
	//编写散列函数，使用取模法
	public int hashFun(int id) {
		return id % size;
	}
	
}


//雇员类
class Emp {
	public int id;
	public String name;
	public Emp next;//在链表中指向下一个雇员
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
	
}

//创建EmpLinkedList,链表类
class EmpLinkedList {
	//头指针，既就是第一个节点
	private Emp head;//默认null
	
	/*
	 * 添加雇员到链表
	 * 说明：
	 * 1.规定id是自增长，因此将该雇员直接加入到本链表的最后即可
	 * 
	 */
	public void add(Emp emp) {
		if(head == null) {//如果是添加第一个
			head = emp;
			return;
		}
		//如果不是添加第一个雇员，则需要一个辅助指针，帮助遍历定位
		Emp curEmp = head;
		while(true) {
			if(emp.next == null) {//说明到链表最后
				break;
			}
			curEmp = curEmp.next;//后移
		}
		curEmp.next = emp;//将emp加入到链表
		
	}
	
	/*
	 * 遍历链表的雇员信息
	 */
	public void list(int no) {
		if(head == null) {
			System.out.println("第" + (no+1) + "条链表为空");
			return;
		}
		System.out.print("第" + (no+1) + "条链表的信息为： ");
		Emp curEmp = head;//辅助指针
		while(true) {
			System.out.println(curEmp);
			
			if(curEmp.next == null) {
				break;
			}
			System.out.println(" =>");
			curEmp = curEmp.next;//后移
		}
		System.out.println();
	}
	
	/*
	 * 查找雇员信息
	 */
	public Emp find(int id) {
		if(head == null) {
			return null;
		}
		Emp curEmp = head;//辅助指针
		while(true) {
			if(curEmp.id == id) {
				break;
			}
			if(curEmp.next == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;//后移
		}
		return curEmp;
	}
	/*
	 * 删除雇员信息
	 * 
	 */
	public void delete(int id) {
		if(head == null) {
			System.out.println("无该雇员信息");
			return;
		}
		if(head.id == id && head.next != null) {
			head.next = head.next.next;
		} else if(head.id == id) {
			head = null;
		} else {
			Emp curEmp = head;
			while(curEmp.next != null) {//删除也就是将它的前一个节点指向它的后一个节点
				if(curEmp.next.id == id) {
					curEmp.next = curEmp.next.next;
				}
				curEmp = curEmp.next;//后移
			}
		}

	}
	
	
}



