package com.atguigu.stack;

import java.util.Scanner;

//链表模拟栈
class LinkedStack{

	private int maxSize;// 栈的大小
	private LinkedList linkedList;// 单链表模拟栈，数据就放在该单链表中
	
	//构造器
	public LinkedStack(int maxSize) {
		this.maxSize = maxSize;
		LinkedList linkedList = new LinkedList();// 单链表初始化
	}
	// 栈满
	public boolean isFull() {
		return linkedList.getSize() == maxSize;
	}
	// 栈空
	public boolean isEmpty() {
		return linkedList.getSize() == 0;
	}
	
	// 入栈——push
	public void push(Number value) {
		if(isFull()) {
			System.out.println("栈满！");
		}
		linkedList.add(value);
	}
	//出栈——pop,将栈顶的数据返回
	public Number pop() {
		if(linkedList.getSize() == 0) {
			throw new RuntimeException("栈空！");
		}
		return linkedList.out();
	}
	//显示栈的情况(遍历),遍历时需要从栈顶开始显示数据

	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		linkedList.show();
	}
	
	 
}
//链表
class LinkedList {
	private Number head = new Number(-1);

	private int size = 0;//表示链表长度
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Number getHead() {
		return head;
	}

	public void setHead(Number head) {
		this.head = head;
	}
	//将数据添加到链表最后面的方法
	public void add(Number value) {
		Number temp = head;
		while(true) {
			if(temp.getNext() == null) {
				break;
			}
			temp.setNext(value);
			size++;
		}
	}
	//将head.next取出的方法
	public Number out() {
		Number value = head.getNext();
		head.setNext(head.getNext().getNext());
		size--;
		return value;
	}
	//显示数据的方法
	public void show() {
		Number temp = head.getNext();
		while(temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
	
	
}



//节点类
class Number{
	private int num;
	private Number next;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Number getNext() {
		return next;
	}
	public void setNext(Number next) {
		this.next = next;
	}
	public Number(int num) {
		super();
		this.num = num;
	}
	@Override
	public String toString() {
		return "Number [num=" + num + "]";
	}
	
	
	
}



public class LinkedStackDemo {

	public static void main(String[] args) {
		//测试
		LinkedStack stack = new LinkedStack(4);
		String key = "";
		boolean loop = true;// 控制是否退出菜单
		Scanner scanner = new Scanner(System.in);
		
			while (loop) {
				System.out.println("show: 表示显示栈");
				System.out.println("exit: 退出程序");
				System.out.println("push: 表示入栈");
				System.out.println("pop: 表示出栈");
				System.out.println("请输入你的选择：");

				key = scanner.next();

				switch (key) {
				case "show":
					stack.list();
					break;
				case "push":
					System.out.println("请输入一个数：");
					int value = scanner.nextInt();
					stack.push(new Number(value));
					break;
				case "pop":
					try {
						Number res = stack.pop();
						System.out.println("出栈的数据是" + res);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					break;
				case "exit":
					scanner.close();
					loop = false;
					break;
				default:
					System.out.println("选择错误，请重新选择：");
					continue;
				}
				
			}
			System.out.println("程序已退出~~~");
	}
	
}
