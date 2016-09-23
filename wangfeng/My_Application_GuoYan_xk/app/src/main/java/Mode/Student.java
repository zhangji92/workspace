package Mode;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/9.
 *
 * 传递哪个类给哪个类实现一个Student
 */
public class Student implements Serializable {

    private String studentName;
    private int sex;//1为男，2为女
    private String age;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String studentName, int sex, String age) {
        this.studentName = studentName;
        this.sex = sex;
        this.age = age;
    }
}
