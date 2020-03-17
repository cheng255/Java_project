package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性，方法，构造器
 *
 * @author nuonuo
 * @create 2020-03-17 18:28
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception {
        Class aClass = Person.class;

        //获取指定的属性:要求运行时类中声明为public
        //通常不用此方法获取属性
        Field id = aClass.getField("id");


        Person p = (Person)aClass.newInstance();

        /*
        设置当前属性的值

        set():参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少

         */

        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int)id.get(p);
        System.out.println(pId);

    }
    /*
    如何操作运行时类的属性

     */
    @Test
    public void test2() throws Exception {
        Class aClass = Person.class;
        //创建运行时类的对象
        Person p = (Person)aClass.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = aClass.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取，设置
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }
    /*
    如何操作运行时类的方法

     */
    @Test
    public void test3() throws Exception {
        Class aClass = Person.class;
        //创建运行时类的对象
        Person p = (Person)aClass.newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod();  参数1：指明获取的方法名，  参数2： 指明获取方法的形参列表
        Method show = aClass.getDeclaredMethod("show", String.class);

        //2.保证当前方法可访问
        show.setAccessible(true);

        //invoke(): 参数1： 方法的调用者  参数2： 给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object chn = show.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("*******如何调用静态方法**********");


        Method showDesc = aClass.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);
//        如果调用的运行时类中的方法没有返回值，则此invoke返回null
        Object invoke = showDesc.invoke(null);//
        System.out.println(invoke);


    }

    /*
    如何调用运行类中指定的构造器
     */
    @Test
    public void test4() throws Exception {
        Class aClass = Person.class;

        /*
        private Person(String name)
        1.调用指定的构造器
        getDeclaredConstructor():指明参数列表
         */

        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);

        //2、保证可访问

        declaredConstructor.setAccessible(true);

        //3.调用次构造器创建运行时类的对象
        Person p = (Person)declaredConstructor.newInstance("Tom");

        System.out.println(p);


    }


}
