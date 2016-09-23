package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Mode.CourseListActivity;
import Mode.Student;

public class Xsxx_jieguo extends AppCompatActivity {

private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xsxx_jieguo);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        textView=(TextView) findViewById(R.id.text_name);

        Intent intent=getIntent();
        String strEdit=(String) intent.getCharSequenceExtra("strEdit");
        Toast.makeText(Xsxx_jieguo.this,strEdit,Toast.LENGTH_SHORT).show();//将传递过来的姓名获取到
        ZiDingYi ziDingYi=(ZiDingYi) getApplication();


         String str="";
        String strSex="";
        for (int i=0;i<ziDingYi.lists.size();i++){



            List<Student> studentsList=ziDingYi.lists.get(i).getStudents();
            for( int j=0;j<studentsList.size();j++){
                if(studentsList.get(j).getStudentName().equals(strEdit)){
                  str += ziDingYi.lists.get(i).getCourseName()+"  ";

                    if(studentsList.get(j).getSex()==1){
                        strSex="男";
                    }else if(studentsList.get(j).getSex()==2){
                        strSex="女";
                    }
                    textView.setText("学生:"+studentsList.get(j).getStudentName()+"  "+"性别:"+strSex+"  "+"年龄:"+studentsList.get(j).getAge()+" "
                            +"选择了:"+str+"课程");
                }
            }
        }


    }



    public void clickText_jg(View view) {
        switch (view.getId()) {
            case R.id.jian_xs_jg:
                Intent intent1 = new Intent(Xsxx_jieguo.this, Xsxx.class);//选修课程
                startActivity(intent1);
                break;
        }
    }
}
