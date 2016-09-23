package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Mode.CourseListActivity;

public class Kcxx_chaxun extends AppCompatActivity {

    private TextView textView_set;
    private CourseListActivity course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcxx_chaxun);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        textView_set = (TextView) findViewById(R.id.text_set);

        Intent intent = getIntent();
        course = ( CourseListActivity) intent.getSerializableExtra("course_get");
        int num = 20 - course.getStudents().size();
        textView_set.setText("课程" + course.getCourseName() + "的老师为:" + course.getTeacherName().gettName() + "还有"+num+"人可选该课程");

    }


    public void clickText_CX(View view) {
        switch (view.getId()) {
            case R.id.jian_c:
                Intent intent1 = new Intent(Kcxx_chaxun.this, Kcxx.class);//选修课程
                startActivity(intent1);
                break;

        }
    }
}
