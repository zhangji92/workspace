package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Mode.CourseListActivity;
import Mode.Student;
import Mode.Teacher;

public class Xxkc extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton Rbnan;
    private RadioButton Rbnv;
    private EditText name;
    private String strname;
    private RadioButton nan;
    private RadioButton nv;
    private EditText age;
    private String strage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxkc);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        Button button = (Button) findViewById(R.id.buttonTi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noNull();
            }
        });

    }


    //箭头返回
    public void returnQ(View view) {

        Intent integer = new Intent(Xxkc.this, MainActivity.class); //返回首页
        startActivity(integer);


    }

    /**
     * 提交信息点击事件
     */
    public void tiJiao() {


    }

    //点击提交信息 相关逻辑处理 判断是否为空
    public void noNull() {
        name = (EditText) findViewById(R.id.name);
        String strname = name.getText().toString();
        RadioButton nan = (RadioButton) findViewById(R.id.nan);
        RadioButton nv = (RadioButton) findViewById(R.id.nan);
        EditText age = (EditText) findViewById(R.id.nianlin);
        String strage = age.getText().toString();

        int i = 1;//默认是男


        if (strname != null && !strname.equals("") || strage != null && !strage.equals("")) {

            if (nan.isChecked()) {//男
                i = 1;
            } else if (nv.isChecked()) {//女
                i = 2;
            }
            Intent in2 = new Intent(Xxkc.this, Xxkc_bh.class); //跳转到选修课程编号页
            Student student = new Student(strname, i, strage);
            in2.putExtra("stu", student);//将student 对象传递
            startActivity(in2);
        } else {
            Toast.makeText(Xxkc.this, "请输入未填写内容", Toast.LENGTH_SHORT).show();
        }


    }


    //判断选中是男是女
    public void radioB(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.nan);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.nv);
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.nan:
                if (checked) {
                    radioButton2.setChecked(false);
                }
                break;
            case R.id.nv:
                if (checked) {
                    radioButton1.setChecked(false);
                }
                break;
        }

    }

}
