package com.example.administrator.wangfeng0530;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Wang0531 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang0531);

        Intent intent=getIntent();//获取一个intent
        String str=intent.getStringExtra("price");//获取intent中的内容
        TextView textView=(TextView)findViewById(R.id.text_View);//获取xml中TextView中的id
        textView.setText("显示:"+str);//将获取的内容放到xml压面上
    }
}
