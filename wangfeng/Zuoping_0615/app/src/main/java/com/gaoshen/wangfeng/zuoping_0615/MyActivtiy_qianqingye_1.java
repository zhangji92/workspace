package com.gaoshen.wangfeng.zuoping_0615;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MyActivtiy_qianqingye_1 extends AppCompatActivity {

    private Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activtiy_qianqingye_1);

        mytoolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        mytoolbar.setTitle("my toolbar");
    }
}
