package com.atguigu.java1;

/**
 * @author nuonuo
 * @create 2020-03-17 17:36
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;
    public Person(){}
    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String display(String interests){
        return interests;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍：" + nation);
        return nation;
    }
    public static void showDesc(){
        System.out.println("我是一个人");
    }


    @Override
    public int compareTo(String o) {

        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
