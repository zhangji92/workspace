package com.gaoshen.wangfeng.wangfeng07070845;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Book {


    private int id;
    private String title;
    private String img;
    private int price;

    public Book() {
        super();
    }

    public Book(String title, String img, int price) {
        super();
        this.title = title;
        this.img = img;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
