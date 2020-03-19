package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		
		//完成将中缀表达式转换为后缀表达式
		//说明
		//1.   1+((2+3)*4)-5 ==> 1 2 3 + 4 * + 5 -
		//2.   因为直接对一个字符串进行操作不方便，因此先转为中缀表达式对应的List
		//既       "1+((2+3)*4)-5" ==> ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
		//3.   将得到的中缀表达式对应的List ==> 后缀表达式对应的List
		//既       ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] ==> ArrayList [1,2,3,+,4,*,+,5,-]
		
		
		String expression = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("中缀表达式对应的List" + infixExpressionList);
		List<String> parseSuffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
		System.out.println("后缀表达式对应的List" + parseSuffixExpreesionList);
		
		int res = calculate(parseSuffixExpreesionList);
		System.out.println("res = " + res);
		
		
		
		
		
//		// 先定义给逆波兰表达式
//		// (3+4)*2-6 => 3 4 + 2 * 6 - 
//		// 为方便，逆波兰表达式的数字和符号使用空格隔开
//		String suffixExpression = "3 4 + 5 * 6 -";
//		// 思路
//		// 1. 先把 "3 4 + 2 * 6 - " => 放到ArrayList中
//		// 2. 将ArrayList传递给一个方法，遍历ArrayList 配合栈完成计算
//		
//		List<String> list = getListString(suffixExpression);
//		System.out.println(list);
//		
//		int res = calculate(list);
//		System.out.println("res = " + res);
		
	}
	//方法 ： 将得到的中缀表达式对应的List ==> 后缀表达式对应的List
	public static List<String> parseSuffixExpreesionList(List<String> ls){
		// 定义 两个栈
		Stack<String> s1 = new Stack<String>(); // 符号栈1
		// 因为 s2 在转换过程中没有pop操作，而且还要逆序输出，因此直接使用List<String> s2
//		Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈2
		List<String> s2 = new ArrayList<String>(); // 储存中间结果的List2
		
		//遍历ls
		for(String item: ls) {
			//如果是一个数，就加入到s2
			if(item.matches("\\d+")) {
				s2.add(item);
			} else if(item.equals("(")) {
				s1.push(item);
			} else if(item.equals(")")) {
				//如果是")",则一次弹出s1栈顶的运算符，并压入s2，直到遇到"("为止，此时将这一对括号丢弃
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop(); // 将此时栈顶"("弹出，消除一对括号
			} else {// 如果是一个运算符
				// 当item的优先级小于或等于栈顶运算符的优先级时
				// 将s1栈顶的运算符弹出并add到s2，再重新和新的栈顶运算符
				// 此时需要一个比较优先级高低的方法
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				// 最后还需要将item压入栈中
				s1.push(item);			
			}
						
		}
		//将s1中剩余的运算符一次弹出并加入到s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		
		return s2; // 注意因为是存放到List ，因此顺序输入就行了
			
	}
	
	
	
	//方法：将中缀表达式转为相应的List , 得到中缀表达式对应的List
	public static List<String> toInfixExpressionList(String s){
		// 定义一个List 存放中缀表达式对应的内容
		List<String> ls = new ArrayList<String>();
		int i = 0; // 指针 用于遍历中缀表达式字符串s
		String str; // 做对多位数的拼接作用
		char c; // 每遍历到一个字符，就放入到c
		do {
			//如果c 是一个非数字，需要加入到ls
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else { // 如果是数，要考虑多位数
				str = ""; // 先将str 置成空串
				while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c; // 拼接
					i++;
				}
				ls.add(str);
			}
		}while(i < s.length());
		
		return ls;		
	}
	
	
	
	//将一个逆波兰表达式 依次将数据和运算符 放到ArrayList中
	public static List<String> getListString(String suffixExpression){
		//将suffixExpression 分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele: split) {
			list.add(ele);
		}
		return list;
	}
	
	//完成对逆波兰表达式的运算
	/*
	 * 1.从左至右扫描，将3 和 4压入栈中
	 * 2.遇到+运算符，因此弹出4 和 3 （4为栈顶元素，3为次顶元素），计算出3+4的值，再将7压入栈中
	 * 3.将5入栈
	 * 4。接下来是 * 运算符，因此弹出5 和 7 计算出5 * 7 = 35，将35入栈
	 * 5. 将6入栈
	 * 6.最后是 - 运算符， 计算出35-6的值，既29，由此得出最终结果
	 * 
	 */
	public static int calculate(List<String> ls) {
		// 创建一个栈
		Stack<String> stack = new Stack<String>();
		// 遍历 ls
		for (String item : ls) {
			// 使用正则表达式来取出数
			if (item.matches("\\d+")) {// 匹配的是多位数
				// 入栈
				stack.push(item);
			} else {
				// pop出两个数，并运算
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					res = 0;
				}
				//将结果res入栈
				stack.push(String.valueOf(res));
			}
			
		}
		//循环结束最后留在栈中的数据就是运算结果
		return Integer.parseInt(stack.pop());

	}
	
		
}

// 编写一个类 Operation 可以返回一个运算符对应的优先级
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	// 方法： 返回对应的优先级数字
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("不存在该运算符");
			break;
		}
		return result;
	}
	
	
	
}


