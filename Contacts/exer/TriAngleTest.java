package com.atguigu.exer;
/*
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有
 * 的底边长base和高height，同时声明公共方法访问私有变量。此外，
 * 提供类必要的构造器。另一边类中使用这些公共方法，计算三角形的面积
 */
public class TriAngleTest {
	public static void main(String[] args) {
		TriAngle t1 = new TriAngle();
		t1.setBase(2.0);
		t1.setHeight(2.4);
		System.out.println("base = " + t1.getBase() + ", " + "height = " + t1.getHeight());
		TriAngle t2 = new TriAngle(5.0,5.4);
		System.out.println("base = " + t2.getBase() + ", " + "height = " + t2.getHeight());
	}

}
