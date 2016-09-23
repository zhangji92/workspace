package com.gaoshen.wangfeng.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    private Button m3_but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        m3_but1= (Button) findViewById(R.id.m3_but1);
        m3_but1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==m3_but1.getId()){
            /**
             * 跳转到用SingleTop 启动却不在栈顶的 Main2Activity
             *
             * 会发现重新 创建了一个Activity 实例
             *
             */
            Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
            startActivity(intent);
        }
    }
}
