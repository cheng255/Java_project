package com.cheng.operation;

import com.cheng.book.BookList;

/**
 * @author nuonuo
 * @create 2020-08-04 9:38
 */
public interface WorkOperation {
    /**
     * 对相应的bookList进行具体的操作
     * @param bookList
     */
    public void work(BookList bookList);
}
