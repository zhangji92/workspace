package Mode;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class CourseListActivity implements Serializable {

    private int id;
    private String courseName;
    private Teacher teacherName;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(Teacher teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public CourseListActivity() {
    }

    public CourseListActivity(int id, String courseName, Teacher teacherName, List<Student> students) {
        this.id = id;
        this.courseName = courseName;
        this.students = students;
        this.teacherName = teacherName;
    }

    /**
     * 验证是否添加过该课程
     */
    public boolean add(Student stude){
        if(stude==null){
            return false;
        }
        for(int i=0;i<students.size();i++){
            if (students.get(i).getStudentName().equals(stude.getStudentName())){
                return false;//判断该课程是否有该学生 有了就不添加
            }
        }
        if(students.size()>20){//容器长度大于20 ，不在添加
            return false;
        }

        students.add(stude);//
        return true;
    }

//    public void get

}
