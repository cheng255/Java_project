package com.cheng.test3;

import java.lang.reflect.Method;

public class ReflectionDemo {
    static class Person {
    }

    public static void main(String[] args) {
        // 打印 Person 的所有方法
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
    }
}
