package com.gaoshen.wangfeng.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{

   private Button m5_but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        m5_but1= (Button) findViewById(R.id.m5_but1);
        m5_but1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==m5_but1.getId()){
            /**
             * 当要启动的Activity 不位于栈顶 系统会把该栈顶的所有Activity 移出栈，
             */
            Intent intent=new Intent(this,Main4Activity.class);
            startActivity(intent);
        }
    }
}
