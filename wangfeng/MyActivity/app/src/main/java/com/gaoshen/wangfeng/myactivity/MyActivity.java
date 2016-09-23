package com.gaoshen.wangfeng.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import Mode.User;

public class MyActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Bundle bundle=getIntent().getExtras();//获取从intent 中传递过来的数据
        User user= (User) bundle.getSerializable("user");//获取bundle中储存的数据
        String id=String.valueOf(user.getId());
        String name=user.getName();

        Toast.makeText(MyActivity.this,id+"----"+name,Toast.LENGTH_SHORT).show();

        button= (Button) findViewById(R.id.but_int);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if (id==button.getId()){

            Bundle bundle=getIntent().getExtras();
            User user= (User) bundle.getSerializable("user");//获取bundle中储存的数据
            String uid=String.valueOf(user.getId());
            String name=user.getName();
            if (uid.equals("1")&& name.equals("小明")){
                Intent intent =new Intent();
                intent.putExtra("str","MyActivtiy的数据返回成功");//向上一个
                setResult(RESULT_OK,intent);
                finish();//关闭Activtiy 返回上一个Activtiy
            }

        }
    }
}
