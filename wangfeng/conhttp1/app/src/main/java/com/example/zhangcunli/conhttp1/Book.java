package com.example.zhangcunli.conhttp1;

/**
 * Created by zhangcunli on 2016/5/13.
 */
public class Book {
    //Variables that are in our json
    private int bookId;
    private String name;
    private String bookface;


    public Book() {
        super();
    }


    public Book(int bookId, String name,String bookface) {
        super();
        this.bookId = bookId;
        this.name = name;
        this.bookface=bookface;
    }

	//Getters and setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookface() {
        return bookface;
    }

    public void setBookface(String bookface) {
        this.bookface = bookface;
    }
}
