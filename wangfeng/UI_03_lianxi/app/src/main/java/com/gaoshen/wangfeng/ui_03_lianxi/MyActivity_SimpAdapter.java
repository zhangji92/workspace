package com.gaoshen.wangfeng.ui_03_lianxi;

import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyActivity_SimpAdapter extends AppCompatActivity {

    private SimpleArrayMap simple_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity__simp_adapter);

        //
        simple_adapter=new SimpleArrayMap();


    }
}
