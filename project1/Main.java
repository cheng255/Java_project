package com.cheng;

import com.cheng.book.BookList;
import com.cheng.user.AdminUser;
import com.cheng.user.NormalUser;
import com.cheng.user.User;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:54
 */
public class Main {
    //登录
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出你的姓名");
        String name = scanner.next();

        System.out.println("请输入你的身份：1：管理员 0：普通用户");
        int n = scanner.nextInt();
        if (n == 1) {
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();//在菜单中的选择
            user.doOperation(choice, bookList);
        }
    }
}
