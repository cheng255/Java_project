package com.atguigu.exer;

/**
 *
 * 银行有一个客户
 * 有两个出乎分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 *
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-10 8:24
 */

class Account{

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt){
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功，当前余额：" + balance);
        }
    }

}


class Customer extends Thread{

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {

        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();


    }

}
