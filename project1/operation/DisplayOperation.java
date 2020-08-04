package com.cheng.operation;

import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:33
 *
 * 显示图书
 */
public class DisplayOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
//        System.out.println("显示");
        Scanner scanner = new Scanner(System.in);
        if (bookList.getSize() == 0) {
            System.out.println("当前没有书籍");
            return;
        }
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
