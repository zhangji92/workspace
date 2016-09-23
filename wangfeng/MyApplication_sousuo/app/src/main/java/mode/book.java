package mode;

/**
 * Created by Administrator on 2016/7/1.
 */
public class book {

    private int bookid;
    private String name;
    private int img;

    public book() {
    }

    public book(int bookid, String name, int img) {
        this.bookid = bookid;
        this.name = name;
        this.img = img;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
