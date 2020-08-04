package com.cheng.operation;

import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:32
 *
 * 借阅书籍
 */
public class BorrowOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅图书的名字：");
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println("找到了,借阅成功");
                bookList.getBook(i).setBorrowed(true);
                return;
            }
        }
        System.out.println("没有此书籍");
    }
}
