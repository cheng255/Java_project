package com.atguigu.java1;

import java.util.Date;

/**
 * 注解的使用
 *
 * 1.理解Annotation
 *
 *
 * 2.Annotation的使用示例
 *
 * 示例一：生成文档相关的注解
 * 示例二：JDK内置基本注解
 * @Override:限定重写父类方法，该注解只能用于方法
 * @Deprecated:用于表示所修饰的元素(类，方法等)已过时
 * @SuppressWarnings:抑制编译器警告
 *
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解，参照@SuppressWarnings
 *
 *      注解声明为@interface
 *      内部定义成员，通常使用value表示
 *      可以指定成员的默认值，使用default定义
 *      如果自定义注解没有成员，表明是一个标识作用
 *
 *
 * 4.jdk提供的4中元注解
 *      元注解：对现有的注解进行解释和说明的注解
 *
 *      Retention:指定所修饰的Annotation 的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *              只有声明为RUNTIME生命周期的注解，才能通过反射获取
 *      Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 *      Documented：表示所修饰的注解在被javadoc解析时，保留下来
 *      Inherited：被它修饰的Annotation具有继承性
 *
 *
 * 5.通过反射获取注解信息
 *
 * 6.jdk8新特性
 *      可重复注解
 *      类型注解
 *
 *
 * @author nuonuo
 * @create 2020-03-12 12:27
 */
public class AnnotationTest {
    public static void main(String[] args) {

        Student student = new Student();
        student.eat();

        Date date = new Date(2000,10,14);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num;

    }
}


class Student extends Person implements Info{
    @Override
    public void show() {

    }

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
}
interface Info{
    void show();
}

@MyAnnotation(value = "hellow")
class Person{
private String name;
private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}