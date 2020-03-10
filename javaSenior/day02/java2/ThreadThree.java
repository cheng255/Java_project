package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三： 实现Callable接口， --- JKD  5.0新增
 *
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable的方式更强大？
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常信息
 * 3.Callable是支持泛型的
 *
 * @author nuonuo
 * @create 2020-03-10 11:12
 */

//1. 创建一个实现Callable的实现类

class NumberThread implements Callable{

//2.重写call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {

        int sum = 0;
        for(int i = 1; i< 100; i++){
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;

    }

}
public class ThreadThree {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumberThread numberThread = new NumberThread();
        //4.将此callable实现类对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numberThread);
        //5.将FutureTask类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并start()调用
        new Thread(futureTask).start();
        //6.可以获取callable中call()的返回值
        try {
            Object sum = futureTask.get();
            System.out.println("总和为" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
