package Mode;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/9.
 */
public class Teacher implements Serializable{

    private String tName;


    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Teacher(String teacherName) {
        this.tName = teacherName;
    }
}
