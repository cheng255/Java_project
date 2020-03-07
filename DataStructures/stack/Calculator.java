package com.atguigu.stack;
/**
 * 简单计算器(运算中不能出现负数)
 * @author 86182
 * 通过栈完成表达式的计算思路 ：
 * 
 * 1.通过一个index值（索引），来遍历我们的表达式
 * 2.如果我们发现是一个数组，就直接入数栈
 * 3.如果我们发现扫描到的是一个符号，就分如下情况
 * 		3.1 如果发现符号栈为空，就直接入符号栈
 * 		3.2 如果符号栈里有操作符，就进行比较，如果当前的操作符优先级等于或小于栈中的
 * 			操作符，就需要从数栈中pop出两个数，再从符号栈中pop出一个操作符，进行运算
 * 			运算结果放入数栈，然后将当前操作符入符号栈；如果当前的操作符优先级大于栈中
 * 			的操作符，就直接入栈。
 * 4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和字符，并运算。
 * 5.最后在数栈只剩一个数字时，这个数字就是表达式的结果
 *
 *
 *
 */
public class Calculator {

	public static void main(String[] args) {
		//完成表达式的运算
		String expression = "3-20*6-2";
		//创建两个栈，数栈和符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		//定义需要的相关变量
		int index = 0;//用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;//运算结果
		char ch = ' ';//将每次扫描得到的char 保存到ch
		String keepNum = "";// 用于拼接多位数
		//开始while循环的扫描expression
		while (true) {
			// 依次得到expression 的每一个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 根据判断ch是什么，然后进行相应的处理
			if (operStack.isOper(ch)) {// 如果是运算符
				// 判断当前的符号栈是否为空
				if (!operStack.isEmpty()) {// 不为空
					// 计较当前运算符和栈中的优先级
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						// 把运算的结果入数栈
						numStack.push(res);
						// 把当前的操作符入符号栈
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}

				} else {// 为空直接入符号栈
					operStack.push(ch);
				}
			} else {// 如果是数，则直接入数栈
				// numStack.push(ch-48);
				// 分析：
				// 1.当处理多位数时，就要在入数栈之前，判断当前位的下一位
				// 2.如果是数就不能马上入栈，如果是符号才能入栈
				// 3.因此我们需要定义一个字符串变量，用于拼接

				// 处理多位数
				keepNum += ch;

				// 如果ch已经是expression的最后一位，就直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {// 判断下一位
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						// 如果后一位是运算符，则入栈
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";// 重点！ 清空keepNum
					}

				}

			}
			// 让index + 1，并判断是否扫描到这个expression的最后
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		// 当表达式扫描完，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行
		while(true) {
			//如果符号栈为空，测计算到最后的结果，数栈中就只有一个数字（结果）
			if(operStack.isEmpty()) {
				break;
			}
			//如果不为空，反复进行运算
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		//结果
		System.out.printf("表达式 %s = %d", expression,numStack.pop());
	}
}

//先创建一个栈类
class ArrayStack2{
	
	private int maxSize;// 栈的大小
	private int[] stack;// 数组模拟栈，数据就放在该数组中
	private int top = -1;// top表示栈顶，初始化为-1
	
	
	//构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];// 数组初始化
	}
	
	//增加一个方法，可以返回当前栈顶的值，但不是pop出来
	public int peek() {
		return stack[top];
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
	
	//返回运算符的优先级，优先级使用数字表示，数字越大，优先级越高
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假定目前计算式里只有 + ，-，*，/ 四种运算符
		}
		
	}
	
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	//计算的方法
	public int cal(int num1,int num2,int oper) {
		int res = 0;//用于存放计算结果
		switch (oper) {//注意运算顺序
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
	
	
}


