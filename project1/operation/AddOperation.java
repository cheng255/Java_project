package com.cheng.operation;

import com.cheng.book.Book;
import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:31
 *
 * 添加图书
 */
public class AddOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("添加图书");
        System.out.println("请输入图书的名字：");
        String name = scanner.next();
        System.out.println("请输入图书的作者：");
        String author = scanner.next();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type = scanner.next();
        Book book = new Book(name, author, price, type);
        int curSize = bookList.getSize();
        bookList.setBook(curSize, book);
        bookList.setSize(curSize + 1);
    }
}
