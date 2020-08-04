package com.cheng.user;

import com.cheng.book.BookList;
import com.cheng.operation.WorkOperation;

/**
 * @author nuonuo
 * @create 2020-08-04 9:44
 */
public abstract class User {
    protected String name;
    WorkOperation[] workOperations; //存储当前对象对应的所有的操作

    public User(String name) {
        this.name = name;
    }

    /**
     * 菜单
     */
    public abstract int menu();


    public void doOperation(int choice, BookList bookList) {
        if (choice < 0 || choice >= this.workOperations.length) {
            System.out.println("输入错误，请重新输入");
        }
        this.workOperations[choice].work(bookList);
    }
}
