package Mode;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/15.
 */
public class AddXingxi implements Serializable{

    private String name;
    private String haoMa;
    private String qq;

    public AddXingxi() {
    }

    public AddXingxi(String name, String haoMa, String qq) {
        this.name = name;
        this.haoMa = haoMa;
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHaoMa() {
        return haoMa;
    }

    public void setHaoMa(String haoMa) {
        this.haoMa = haoMa;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
