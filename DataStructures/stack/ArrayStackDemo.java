package com.atguigu.stack;

import java.util.Scanner;

//定义一个类表示栈结构
class ArrayStack{
	
	private int maxSize;// 栈的大小
	private int[] stack;// 数组模拟栈，数据就放在该数组中
	private int top = -1;// top表示栈顶，初始化为-1
	
	
	//构造器
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];// 数组初始化
	}
	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	// 入栈——push
	public void push(int value) {
		//先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}
	//出栈——pop,将栈顶的数据返回
	public int pop() {
		//先判断栈是否空
		if (isEmpty()) {//抛出运行时异常
			throw new RuntimeException("栈空，没有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//显示栈的情况(遍历),遍历时需要从栈顶开始显示数据
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d] = %d\n", i, stack[i]);
		}
	}
	
	
	
}

public class ArrayStackDemo {
@SuppressWarnings("resource")
public static void main(String[] args) {
	//测试Array
	ArrayStack stack = new ArrayStack(4);
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
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
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
