package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-17 14:47
 */
public class ReflectionTest {

    //反射之前，在Person类外部，不可以通过对象调用其内部的私有结构

    //反射之后

    @Test
    public void test1() throws Exception {
        Class<Person> aClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor<Person> constructor = aClass.getConstructor(String.class, int.class);

        Person p = constructor.newInstance("Tom", 12);
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性和方法
        //调属性
        Field age = aClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        //调方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构的。
        //调用私有的构造器
        Constructor<Person> constructor1 = aClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = constructor1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有的属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"mike");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于String name = p1.showNation("中国")
        System.out.println(nation);


    }
//    反射的特征：动态性

    //Q:如何看待两个技术：封装性和反射

    //A:不矛盾

    /*
    对于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令之后，会生成一个或多个字节码文件(.class结尾)。接着我们使用java.exe命令对
    某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中，此过程就称为类的加载，加载到内存
    中的类，就称为运行时类，此运行时类，就作为Class的一个实例

    2.换句话说，Class的示例就对应着一个运行时类

    3.加载到内存中的运行时类，会缓存一定的时间，在此时间内，我们可以通过不同的方式来获取此运行时类


     */

    //获取Class的实例方式（前三种方式需要掌握）
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一:调用运行时类的属性：.class
        Class<Person> aClass1 = Person.class;
        System.out.println(aClass1);

        //方式二:通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class aClass2 = p1.getClass();
        System.out.println(aClass2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class aClass3 = Class.forName("com.atguigu.java.Person");
        System.out.println(aClass3);

        System.out.println(aClass1 == aClass2);//true
        System.out.println(aClass1 == aClass3);//true

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class aClass4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(aClass4);

    }
    /*
    Properties: 用来读取配置文件

     */

    @Test
    public void test3() throws Exception {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：
        //此时文件默认识别为：当前module的src下
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name = " + user + ",password = " + password);


    }




}
