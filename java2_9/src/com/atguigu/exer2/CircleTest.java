package com.atguigu.exer2;

public class CircleTest {
	
	public static void main(String[] args) {
		
		Circle p1 = new Circle("black" , 1.1, 5);
		Circle p2 = new Circle("black" , 1.1, 6);
		
		System.out.println(p1.color.equals(p2.color));//true
//		System.out.println(p1.color == p2.color);//true
		
		System.out.println(p1.equals(p2));//false
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		
	}

}
