package com.gaoshen.wangfeng.my_application_guoyan;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Mode.CourseListActivity;
import Mode.Student;
import Mode.Teacher;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ZiDingYi extends Application implements Serializable{

   static List<CourseListActivity> lists=new ArrayList<CourseListActivity>();
    @Override
    public void onCreate() {
        super.onCreate();

        //自定义ApplicationContext()
//        Toast.makeText(getApplicationContext(),"application",Toast.LENGTH_SHORT).show();

        Teacher tc1=new Teacher("郭阳");
        Teacher tc2=new Teacher("于文斌");
        Teacher tc3=new Teacher("王立峰");

        List<Student> stu1=new ArrayList<Student>();
        List<Student> stu2=new ArrayList<Student>();
        List<Student> stu3=new ArrayList<Student>();

        CourseListActivity clist1=new CourseListActivity(1,"Android",tc1,stu1);
        CourseListActivity clist2=new CourseListActivity(2,"js",tc2,stu2);
        CourseListActivity clist3=new CourseListActivity(3,"java",tc3,stu3);
        lists.add(clist1);
        lists.add(clist2);
        lists.add(clist3);

    }


}
