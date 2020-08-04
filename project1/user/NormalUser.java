package com.cheng.user;

import com.cheng.operation.*;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:45
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        workOperations = new WorkOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=======================");
        System.out.println("hello" + this.name + ",欢迎来到图书馆");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }
}
