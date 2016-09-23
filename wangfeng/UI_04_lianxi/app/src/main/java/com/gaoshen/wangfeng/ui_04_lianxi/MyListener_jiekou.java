package com.gaoshen.wangfeng.ui_04_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyListener_jiekou extends AppCompatActivity implements View.OnClickListener {

    private Button button_jiekou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listener_jiekou);

        //接口实现监听事件
        button_jiekou.setOnClickListener(this);


    }

    /**
     * 实现接口
     * @param v 控件
     */
    @Override
    public void onClick(View v) {

        String str="接口实现监听事件";
        Toast.makeText(MyListener_jiekou.this,str,Toast.LENGTH_SHORT);
    }
}
