package gaosheng.util;

import java.io.Serializable;

/**
 * Created by zhaofuqiang on 2016/8/16.
 */
public class Student  implements Serializable{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Student() {

    }
}
