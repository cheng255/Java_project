package com.cheng.operation;

import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:34
 *
 * 归还图书
 */
public class ReturnOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
//        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅图书的名字：");
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println("归还成功");
                bookList.getBook(i).setBorrowed(false);
                return;
            }
        }
        System.out.println("此书籍不属于该图书馆");
    }
}
