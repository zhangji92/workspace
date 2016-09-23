package com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1;

/**
 * Created by Administrator on 2016/8/31.
 */
public class Ad {

    private String id;
    private String title;
    private String pic;
    private String link;

    public Ad() {
    }

    public Ad(String id, String title, String pic, String link) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
