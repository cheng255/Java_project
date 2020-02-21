package com.atguigu.exer2;

public class Circle extends GeometricObject{

	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, double weight,double radius) {
		super(color, weight);
		this.radius = radius;
	}

	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//计算圆的面积
	public double findArea() {
		return Math.PI * radius * radius;
	}
	//重写equals()方法，比较两个圆的半径是否相等，如相等，返回true
	@Override
	public boolean equals(Object obj) {
	
		if(this == obj) {
			return true;
		}
		if(obj instanceof Circle) {
			Circle other = (Circle) obj;
			
			if(this.radius == other.radius) {
				return true;
			}
		}
		
		return false;
	}
	
	//重写toString方法，输出圆的半径
	@Override
	public String toString() {
	
		
		return "Radius = " + getRadius();
		
	}
	
	
	
}
