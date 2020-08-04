package com.cheng.operation;

import com.cheng.book.BookList;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-08-04 9:32
 *
 * 删除图书
 */
public class DelOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除图书的名字：");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("没有要删除的书籍");
            return;
        }
        int curSize = bookList.getSize();
        for (; i < bookList.getSize()-1; i++) {
            bookList.setBook(i, bookList.getBook(i+1));
        }
        bookList.setSize(curSize-1);
        System.out.println("删除成功");

    }
}
