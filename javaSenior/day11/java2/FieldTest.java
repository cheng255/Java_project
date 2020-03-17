package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 *
 * @author nuonuo
 * @create 2020-03-17 17:48
 */
public class FieldTest {


    @Test
    public void test1(){
        Class aClass = Person.class;


        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for(Field f: fields){
            System.out.println(f);
        }

        System.out.println();
        //getDeclaredFields():获取当前运行时类声明的所有属性，（不包含父类中的属性）
        Field[] declaredField = aClass.getDeclaredFields();
        for(Field f : declaredField){
            System.out.println(f);
        }
    }

    //权限修饰符 数据类型 变量名 =
    @Test
    public void test2(){
        Class aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String name = f.getName();
            System.out.print(name + "\t");
            System.out.println();
        }


    }




}
