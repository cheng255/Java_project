package com.atguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改成线程安全
 *
 * @author nuonuo
 * @create 2020-03-09 19:08
 */
public class BankTest {
}

class Bank {

    private Bank(){};

    private static Bank instance = null;

    private static Bank getInstance(){

        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二：效率高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }

            }
        }

        return instance;

    }
}
