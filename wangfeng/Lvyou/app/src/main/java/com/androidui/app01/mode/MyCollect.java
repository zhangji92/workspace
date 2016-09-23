package com.androidui.app01.mode;


import java.util.Date;

/**
 * Created by zhangcunli on 2016/6/16.
 */
public class MyCollect {
    private int image;
    private String title;
    private String whatWay;
    private double price;
    private Date goDate;

    public MyCollect() {
    }

    public MyCollect(int image, String title, String whatWay, double price, Date goDate) {
        this.image = image;
        this.title = title;
        this.whatWay = whatWay;
        this.price = price;
        this.goDate = goDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhatWay() {
        return whatWay;
    }

    public void setWhatWay(String whatWay) {
        this.whatWay = whatWay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getGoDate() {
        return goDate;
    }

    public void setGoDate(Date goDate) {
        this.goDate = goDate;
    }
}
