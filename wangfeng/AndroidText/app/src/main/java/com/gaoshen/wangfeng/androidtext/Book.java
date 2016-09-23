package com.gaoshen.wangfeng.androidtext;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Book {

    private int bookid;
    private String bookName;
    private String bookauthor;

    public Book(int bookid, String bookName, String bookauthor) {
        this.bookid = bookid;
        this.bookName = bookName;
        this.bookauthor = bookauthor;
    }

    public Book(){}

    public Book(String bookName, String bookauthor) {
        this.bookName = bookName;
        this.bookauthor = bookauthor;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
}
