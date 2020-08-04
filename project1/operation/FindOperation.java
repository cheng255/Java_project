package com.cheng.operation;

import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:34
 *
 * 查找图书
 */
public class FindOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
//        System.out.println("查找");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找图书的名字：");
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println("找到了");
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("没有此书籍");
    }
}
