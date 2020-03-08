package com.atguigu.exer;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		
//		p1.age = 1;The field Person.age is not visible(编译不通过)
		p1.setAge(12);
		
		System.out.println("年龄为" + p1.getAge());
		
		Person p2 = new Person("tom",21);
		System.out.println("name = " + p2.getName() + "," + "age = " + p2.getAge());
	}
}
