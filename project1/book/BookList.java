package com.cheng.book;

/**
 * @author nuonuo
 * @create 2020-08-04 9:24
 */
public class BookList {

    private Book[] books = new Book[10];
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BookList() {
        books[0] = new Book("西游记", "吴承恩", 100, "小说");
        books[1] = new Book("西游记", "吴承恩", 100, "小说");
        books[2] = new Book("西游记", "吴承恩", 100, "小说");
        size = 3;
    }
    public void setBook(int index, Book book) {
        this.books[index] = book;
    }
    public Book getBook(int index) {
        return books[index];
    }
}
