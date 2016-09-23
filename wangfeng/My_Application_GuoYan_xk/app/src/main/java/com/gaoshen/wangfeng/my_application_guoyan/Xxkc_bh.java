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


import java.util.List;

import Mode.CourseListActivity;
import Mode.Student;


public class Xxkc_bh extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private LayoutInflater layoutInflate;//申明layoutInflate
    private List<CourseListActivity> list;
    private Student stu;//接收页面跳转传过来的Student 对象
    private BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxkc_bh);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        layoutInflate = this.getLayoutInflater();//初始化layoutInflate
        listView = (ListView) findViewById(R.id.list_view);

        Intent intent = getIntent();
        stu=(Student) intent.getSerializableExtra("stu");//跳转当前页 获取student 对象
//        Toast.makeText(Xxkc_bh.this,stu.getStudentName(),Toast.LENGTH_SHORT).show();
        // ;
        //
        ZiDingYi zi = (ZiDingYi) getApplication();
        list = zi.lists;


        listView.setAdapter(bada());
        listView.setOnItemClickListener(this);//为listView中的元素添加点击事件
    }

    //为listView中的元素添加点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



//        Toast.makeText(Xxkc_bh.this,"00"+ziDingYi.lists.size(),Toast.LENGTH_SHORT).show();
        //调用add 方法 判断该学生有没有添加该课程
       boolean boo= list.get(position).add(stu);
        if (boo==true){//true表示没有添加过该课
            Toast.makeText(Xxkc_bh.this,"添加选课成功",Toast.LENGTH_SHORT).show();
            baseAdapter.notifyDataSetChanged();//通知适配器重新加载（即时刷新）
        }else if(boo==false){
            Toast.makeText(Xxkc_bh.this,"添加选课失败",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 适配器
     *
     * @return
     */
    public BaseAdapter bada() {
       baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ////通过layoutInflate这个引用 .inflate 获取一个布局文件
                View view = layoutInflate.inflate(R.layout.activity_kcxx_list, null);


                TextView text1 = (TextView) view.findViewById(R.id.text_list1);
                //set一个编号
                text1.setText(String.valueOf(list.get(position).getId()));

                TextView text2 = (TextView) view.findViewById(R.id.text_list2);
                //set一个课程名
                text2.setText(list.get(position).getCourseName());
                TextView text3 = (TextView) view.findViewById(R.id.text_list3);
                //set一个老师名
                text3.setText(list.get(position).getTeacherName().gettName());
                TextView text4 = (TextView) view.findViewById(R.id.text_list4);
                //set选课人数
                text4.setText(String.valueOf(list.get(position).getStudents().size()));


                return view;
            }
        };
        return baseAdapter;
    }

    public void returnBh(View view) {
        switch (view.getId()) {
            case R.id.xuanjian:
                Intent integer = new Intent(Xxkc_bh.this, Xxkc.class); //返回首页
                startActivity(integer);
                break;

        }

    }
}
