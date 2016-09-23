package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Bz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bz);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);
    }

    public void clickText_bz(View view) {
        switch (view.getId()) {
            case R.id.jian_bz:
                Intent intent1 = new Intent(Bz.this, MainActivity.class);//首页
                startActivity(intent1);
                break;
        }
    }
}
