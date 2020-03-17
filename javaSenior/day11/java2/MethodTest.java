package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 获取运行时类的方法结构
 *
 *
 * @author nuonuo
 * @create 2020-03-17 18:05
 */
public class MethodTest {

    @Test
    public void test1(){

        Class aClass = Person.class;

        //获取方法
        //getMethods():获取当前运行时类及其父类中声明为public的方法
        Method[] methods = aClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();
        //获取当前运行时类中声明的所有的方法，不包含父类
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }

    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名(参数类型1 形参名1，...) throws XxxException{}
     */

}
