package com.atguigu.java1;

import java.io.Serializable;

/**
 * 要可序列化，满足如下要求
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现SerialVersionUID之外，还必须保证其内部所有属性
 * 也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *
 *
 * 补充：ObjectInputStream和ObjectOutputStream不能序列化static和Transient修饰的成员变量
 *
 * @author nuonuo
 * @create 2020-03-16 17:59
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -68497970754667710L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
