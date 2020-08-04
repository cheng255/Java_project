package com.cheng.operation;

import com.cheng.book.BookList;

/**
 * @author nuonuo
 * @create 2020-08-04 9:34
 *
 * 退出系统
 */
public class ExitOperation implements WorkOperation{
    @Override
    public void work(BookList bookList) {
//        System.out.println("退出系统");
        System.exit(0);
    }
}
