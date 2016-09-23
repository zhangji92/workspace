package mode;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MyCollect {
    //图片
    private int image;
    //标题
    private String title;
    //旅游方式
    private String whatWay;
    //费用
    private double price;
    //出发日期
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
