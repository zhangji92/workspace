package com.gaoshen.wangfeng.my_application_guoyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Kcxx_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcxx_list);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);
    }
}
