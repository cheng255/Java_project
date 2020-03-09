package com.atguigu.java1;

/*
 * 一：继承性的好处：
 * 1 提高了代码的复用性
 * 2 便于功能的拓展
 * 3 为多态性的使用，提供了前提
 * 
 * 二：继承性的格式：A extends B{}
 * A：子类，派生类，subclass
 * B：父类，超类，基类，superclass
 * 
 * 2.1体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的结构 属性 方法
 * 特别的，父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构
 * 只是因为封装性的影响，使得子类不能直接调用父类的结构而已
 * 2.2 子类继承父类以后，还可以声明自己特有的属性或方法，实现功能的拓展。
 * 子类和父类的关系，不同于子集和集合的关系
 * extends：延展，扩展
 * 
 * 三：java中关于继承性的规定
 * 1，一个类可以有多个子类
 * 2，单继承性：一个类只能有一个父类
 * 3.子父类是相对的概念
 * 4.子类直接继承的类叫直接父类，......间接父类
 * 
 * 四：
 * 1.如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类
 * 2.所有的java类（除java.lang.Object类之外）都直接或间接的继承于java.lang.Object类
 * 3.意味着，所有的java类具有java.lang.Object类声明的功能。
 * 
 * 五：重写操作
 * 1.重写：子类继承父类以后，可以对父类中同名同参数的方法进行覆盖操作
 * 2.应用：重写后，调用时实际执行的是子类重写父类的方法
 * 
 * 3：重写的规定
 *          方法的声明： 权限修饰符  返回值类型  方法名（形参列表）{
 *          
 *          		//方法体
 *          }
 *          
 *   		A：子类重写的方法名和形参列表与父类相同
 *   		B: 子类重写的方法的权限修饰符不小于父类被重写的方法权限修饰符
 * 			C: 子类中不能重写父类中声明为private的方法
 * 			D: 返回值类型：
 * 				<<父类被重写的方法返回值类型为void时，则子类重写的方法的返回值只能是void
 * 				<<父类被重写的方法返回值类型为A类时，则子类重写的方法的返回值可为A类或A类的子类
 * 			E:子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * *************************************************************************************
 * 			子类和父类中的同名同参数的方法要么都声明为非static的（考虑重写），要么都声明为static的（不是重写）
 * 				
 */
public class ExtendsTest {
	

	public static void main(String[] args) {
		
		
		
//		Student p1 = new Student("张三", 19, '男');
		Student p2 = new Student();
		
		p2.setName("张三");
		System.out.println(p2.getName());
		p2.Studying();
		
		System.out.println("***********************************");
		
		Doctor p3 = new Doctor("临床");
		
		System.out.println(p3.major);
		p3.Studying();
		
		
		
		
		
//		Doctor p = new Doctor();
//		p.toString();
	}

}