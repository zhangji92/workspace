package com.example.administrator.wangfeng0530;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //将内容赋给静态常量
//    public static final String PRICE=com.example.administrator.wangfeng0530.message;

    private Button loginButton;
    private EditText  edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton=(Button) findViewById(R.id.sendMessageBtn);
        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Wang0531.class);
                edit = (EditText) findViewById(R.id.editText);//获取EditView中的id
                String message= edit.getText().toString();//获取指定EditView  id 的内容
                intent.putExtra("price",message);//将内容赋给price
                startActivity(intent);//启动这个Activity 并带上intent


            }
        });

    }

}