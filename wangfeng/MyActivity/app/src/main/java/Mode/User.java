package Mode;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/22.
 */
public class User implements Serializable{

    private int id;
    private  String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
