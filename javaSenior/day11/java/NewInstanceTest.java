package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author nuonuo
 * @create 2020-03-17 16:28
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> aClass = Person.class;

        /*
        newInstance():调用此方法，创建对应的运行时类的对象
            内部调用了运行时类的空参构造器

            要想此方法正常创建运行时类的对象，要求：
            1.运行时类必须提供空参的构造器
            2.空参的构造器访问权限要够，通常public


            在javabean中要求提供一个public的空参构造器。原因
            1.便于通过反射创建运行时类的对象
            2.便于子类继承此运行时类时，默认调用super()时，保证父类由此构造器

         */
        Person p = aClass.newInstance();
        System.out.println(p);

    }

    @Test
    public void test2() {

        int num = new Random().nextInt(3);//返回随机数0,1,2
        String classPath = "";
        switch(num){
            case 0:
                classPath = "com.atguigu.java.ReflectionTest";

                break;

            case 1:
                classPath = "java.lang.Object";
                break;

            case 2:
                classPath = "com.atguigu.java.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
创建一个指定类的对象
classPath:指定类的全类名
 */
    public Object getInstance(String classPath) throws Exception {

        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

}
