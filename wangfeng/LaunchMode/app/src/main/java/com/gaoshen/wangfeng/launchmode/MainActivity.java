package com.gaoshen.wangfeng.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button standard,singleTop__1,singleTop__2,SingleTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        standard = (Button) findViewById(R.id.standard);
        standard.setOnClickListener(this);
        singleTop__1 = (Button) findViewById(R.id.singleTop__1);
        singleTop__1.setOnClickListener(this);
        singleTop__2 = (Button) findViewById(R.id.singleTop__2);
        singleTop__2.setOnClickListener(this);
        SingleTask = (Button) findViewById(R.id.SingleTask);
        SingleTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id ==  standard.getId()) {
            /**standard 模式
             *
             * 默认的启动方法  每启动一次Activity 时 创建一个Activity的实例（退出时需要点击多次Back才能退出）
             */
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id ==  singleTop__1.getId()) {
            /**
             * SingleTop 模式
             *
             */
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else if (id ==  singleTop__2.getId()) {
            /**
             * SingleTop 模式
             *
             */
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else if (id ==  SingleTask.getId()) {
            /**
             * SingleTop 模式
             *
             */
            Intent intent = new Intent(MainActivity.this, Main4Activity.class);
            startActivity(intent);
        }

    }
}
