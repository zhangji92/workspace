package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Mode.CourseListActivity;
import Mode.Teacher;

public class Kcxx extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView_kc;
    private List<CourseListActivity> list_course;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcxx);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        /**
         * 从ZiDingYi 中获取数据源
         * 存放在list_course的这个list中
         */
        ZiDingYi ziding = (ZiDingYi) getApplication();
        list_course = ziding.lists;
        listView_kc = (ListView) findViewById(R.id.list_kcxx);
        listView_kc.setAdapter(base());

        Intent intent=getIntent();
        String string=(String) intent.getCharSequenceExtra("what");
        if (string==null){//判断传过来的数据是否为空  为空时为List添加点击事件
            listView_kc.setOnItemClickListener(this);//为list添加点击点击监听事件
        }


        //给inflater 初始化
        inflater = this.getLayoutInflater();

    }


    public BaseAdapter base() {
        BaseAdapter base = new BaseAdapter() {
            @Override
            public int getCount() {
                return list_course.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = inflater.inflate(R.layout.activity_kcxx_list, null);

                TextView text1 = (TextView) view.findViewById(R.id.text_list1);
                //set一个编号
                text1.setText(String.valueOf(list_course.get(position).getId()));

                TextView text2 = (TextView) view.findViewById(R.id.text_list2);
                //set一个课程名
                text2.setText(list_course.get(position).getCourseName());
                TextView text3 = (TextView) view.findViewById(R.id.text_list3);
                //set一个老师名
                text3.setText(list_course.get(position).getTeacherName().gettName());
                TextView text4 = (TextView) view.findViewById(R.id.text_list4);
                //set选课人数
                text4.setText(String.valueOf(list_course.get(position).getStudents().size()));

                return view;
            }

        };
        return base;
    }

    /**
     * 点击查询课程详细信息
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       CourseListActivity course= list_course.get(position);
        Intent intent_get = new Intent(Kcxx.this, Kcxx_chaxun.class);
        intent_get.putExtra("course_get", course);
        startActivity(intent_get);

    }

    /**
     * 跳转页面
     *
     * @param view
     */
    public void clickText_KC(View view) {
        switch (view.getId()) {
            case R.id.jian_K:
                Intent intent1 = new Intent(Kcxx.this, MainActivity.class);//选修课程
                startActivity(intent1);
                break;

        }
    }
}
