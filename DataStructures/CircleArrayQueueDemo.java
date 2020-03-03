package com.atguigu.queue;

import java.util.Scanner;

//思路如下：
/*//问题分析既优化
//1.目前数组使用一次就不能用了，没有达到复用的作用
//2.将这个数组使用算法，改成一个环型数组： 取模%
 * 
 * 
 * 1.front变量的含义做一个调整，front指向队列的第一个元素，既arr[front]就是队列的第一个元素
 * front的初始值为0
 * 2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，可以空出一个空间作为约定
 * rear的初始值为0
 * 3.当队列满时，条件是(rear+1)%maxSize = front
 * 4.当队列空时，条件为rear == front
 * 5.当我们这样分析时，队列中有效数据的个数为：(rear - front + maxSize) % maxSize
 * 
 * 
 */
public class CircleArrayQueueDemo {
public static void main(String[] args) {
	//测试
	System.out.println("测试数组模拟环形队列案例");
	//创建一个环形队列
	CircleArrayQueue arrayQueue = new CircleArrayQueue(3); 
		char key = ' ';// 接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':// 显示队列
				arrayQueue.showQueue();
				break;
			case 'a':// 添加数据
				System.out.println("请输入一个     数");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':// 取出数据
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;

			case 'h':// 查看队列头的数据
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':// 退出
				scanner.close();
				loop = false;
				break;

			default:
				break;
			}

		}

		System.out.println("程序退出");

}

}

//使用数组模拟队列——编写一个ArrayQueue类
class CircleArrayQueue{
	private int maxSize;//表示数组最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数组用于存放数据，模拟队列
	
	//创建对列的构造器
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;//front指向队列的第一个元素，既arr[front]就是队列的第一个元素
		rear = 0;//rear指向队列的最后一个元素的后一个位置，可以空出一个空间作为约定
	}
	
	//判断队列是否满
	public boolean isFull() {
		
		return (rear + 1) % maxSize == front;
	}
	
	//判断队列是否空
	public boolean isEmpty() {
		
		return rear == front;
	}
	
	//添加数据到队列
	public void addQueue(int n) {
		//判断队列是否满
		if(isFull()) {
			System.out.println("队列已满，不能再加入数据");
			return;
		}

		arr[rear] = n;
		//将rear后移，这里必须考虑 %
		rear = (rear + 1) % maxSize;
		
	}
	
	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否空
		if(isEmpty()) {
			//通过抛出异常处理
			throw new RuntimeException("队列空，不能去数据");
		}
//		这里需要分析出front是指向队列的第一个元素
		// 1. 先把front对应的值保留给一个临时变量
		// 2. 将front 后移，考虑取模
		// 3. 将临时保存的变量返回
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	
	//显示队列的所有数据
	public void showQueue() {
		//遍历
		if(isEmpty()) {
			System.out.println("队列空，没有数据");
			return;
		}
		//思路：从front开始遍历，遍历多少个元素
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	//求出当前队列有效数据的个数
	public int size() {
		
		return (rear - front + front) % maxSize;
		
	}
	
	//显示队列的头数据，注意不是取出数据
	public int headQueue() {
		//判断
		if(isEmpty()) {
			
			throw new RuntimeException("队列空，没有数据");
		}
		return arr[front];
	}
	
	
	
}