package com.cheng.java1;

import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-08-07
 * Time: 8:19
 */
class MyException extends RuntimeException{
    public MyException(String msg) {
        super(msg);
    }
}
public class TestDemo {

    public static void func() throws MyException{
        throw new MyException("我的MyException");
    }

    public static void main(String[] args) {

        //throw new NullPointerException("空指针异常");

      /*  func();
        System.out.println("fafafa");*/
        try {
            func();
        }catch (MyException e){
            System.out.println("捕获了MyException");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
