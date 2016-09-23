package com.gaoshen.wangfeng.wangfeng20160706;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MyActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }



}
