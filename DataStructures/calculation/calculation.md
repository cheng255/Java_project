

#              计算器java实现（逆波兰）

## 思路

#### 一：将输入的中缀表达式转换为后缀表达式

例如    ：1 + ( ( 2 + 3 ) * 4 ) - 5  ==> 1 2 3 + 4 * + 5 -

1. 先将表达式字符串存入List集合，便于操作
   既       "1+((2+3)*4)-5" ==> List [1,+,(,(,2,+,3,),*,4,),-,5]

2. 将得到的中缀表达式对应的List ==> 后缀表达式对应的List
   既      List [1,+,(,(,2,+,3,),*,4,),-,5] 

   ​			==> List [1,2,3,+,4,*,+,5,-]

   ##### 具体步骤

   1. 初始化两个栈：运算符栈s1和存储中间结果的栈s2
   2. 从左至右扫描中缀表达式
   3. 遇到操作数时，将其压入s2
   4. 遇到运算符时，则比较其与栈顶运算符的优先级
      - 如果s1为空，或栈顶运算符为左括号“（”，则直接将此运算符入栈
      - 否则，若优先级比栈顶运算符的优先级高，也将运算符压入s1
      - 否则，将s1栈顶的运算符弹出并压入s2，然后继续与栈顶比较，反复执行

      5.遇到括号时：

   - ​	 如果是左括号’（‘ 则直接压入s1

   - ​     如果是右括号’）‘ 则一次弹出s1栈顶的运算符，并压入s2, 直到遇到左括号为止，

   - ​     然后将这一对括号丢弃

     

      6.重复 2 - 5 ，直到扫描完表达式

      7.将s1中剩余的运算符依次弹出并压入s2

      8.依次弹出s2中的元素并输出，结果的逆序既为中缀表达式对应的后缀表达式

**注意**：在真正代码实现中，因为s2栈只起到了存放中间值作用，并且结束后还需要逆序。

​			因此通常使用List代替，更为方便



#### 二：用后缀表达式的计算机求值

#####  具体步骤

1.从左至右扫描表达式

2.遇到数时，将数压入栈中

3.遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算，并将结果入栈

4.重复操作，直到最后一次运算得出的结果即为表达式的结果



## 代码实现

#### 代码分析：

###### 	一共用写三个方法

- 方法1.将中缀表达式转为相应的List

- 方法2.将得到的中缀表达式对应的List ==> 后缀表达式对应的List

- 方法3.完成对逆波兰（后缀）表达式的运算

  ###### 一个类

  - 用于返回一个运算符对应的优先级

  

  

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {		
			String expression = scanner.nextLine();
			double result = CalculateResult(expression); 
			System.out.println("结果为" + result);
		}
		
	}
	

	/**
	 * 	//封装前面的方法
	 * @param expression 需要计算的字符串式
	 * @return 计算结果
	 */
	public static double CalculateResult(String e) {
		if(e == null || e.length() == 0) {
			throw new RuntimeException("输入的表达式有误");
		}
		//去掉字符串中的空格
		String expression = e.replace(" ", "");
		//得到中缀表达式对应的List
		List<String> Infixlist = toInfixExpressionList(expression);
		//得到对应的后缀表达式List
		List<String> suffixList = parseSuffixExpreesionList(Infixlist);
		//使用逆波兰计算
		double result = calculate(suffixList);
		return result;
	}

	
	//方法 ： 将得到的中缀表达式对应的List ==> 后缀表达式对应的List
	public static List<String> parseSuffixExpreesionList(List<String> ls){
		// 定义 两个栈
		Stack<String> s1 = new Stack<String>(); // 符号栈1
		// 因为 s2 在转换过程中没有pop操作，而且还要逆序输出，因此直接使用List<String> s2
		//Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈2替换为
		List<String> s2 = new ArrayList<String>(); // 储存中间结果的List2
		
		//遍历ls
		for(String item: ls) {
			//如果是一个数，就加入到s2
			if(item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) {//正则表达式，匹配正数负数和小数
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
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= 			                          Operation.getValue(item)) {
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

	//方法：将中缀表达式转为相应的List
	public static List<String> toInfixExpressionList(String s){
		// 定义一个List 存放中缀表达式对应的内容
		List<String> ls = new ArrayList<String>();
		int i = 0; // 指针 用于遍历中缀表达式字符串s
		String str; // 做对多位数的拼接作用
		char c; // 每遍历到一个字符，就放入到c
		do {
			//如果c 是一个非数字，并且不是'.'小数点，需要加入到ls
			if( ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) 
					&& (c = s.charAt(i)) != '.') {
				ls.add("" + c);
				i++;
			} else { // 如果是数，要考虑多位数和小数
				str = ""; // 先将str 置成空串
				while(i < s.length() && (((c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <=                  57) || ((c = s.charAt(i)) == '.'))){
					str += c; // 拼接
					i++;
				}
				ls.add(str);
			}
		}while(i < s.length());
		
		return ls;		
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
	public static double calculate(List<String> ls) {
		// 创建一个栈
		Stack<String> stack = new Stack<String>();
		// 遍历 ls
		for (String item : ls) {
			// 使用正则表达式来取出数
			if (item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) {// 匹配的是多位数
				// 入栈
				stack.push(item);
			} else {
				// pop出两个数，并运算
				double num2 = Double.parseDouble(stack.pop());
				double num1 = Double.parseDouble(stack.pop());
				double res;
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
		return Double.parseDouble(stack.pop());

	}
	
		
}

// 此类 Operation 用于返回一个运算符对应的优先级
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
			break;
		}
		return result;
	}

}
```

#### 运行截图

<img src="C:\Users\86182\AppData\Roaming\Typora\typora-user-images\1586064412427.png" style="zoom: 50%;" />

有错误还望指出，谢谢