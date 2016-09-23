package com.gaoshen.wangfeng.ui_04_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyListener_duixiang_biaoqian extends AppCompatActivity {

    private Button button_duixiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listener_duixiang);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str="对象实现监听事件";
                Toast.makeText(MyListener_duixiang_biaoqian.this,str,Toast.LENGTH_SHORT);
            }

        };
        //对象实现监听事件
        button_duixiang.setOnClickListener(listener);
    }
}
