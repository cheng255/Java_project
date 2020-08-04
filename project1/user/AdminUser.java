package com.cheng.user;

import com.cheng.operation.*;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:46
 */
public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        workOperations = new WorkOperation[] {
            new ExitOperation(),
            new FindOperation(),
            new AddOperation(),
            new DelOperation(),
            new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=======================");
        System.out.println("hello" + this.name + "欢迎来到图书馆");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }
}
