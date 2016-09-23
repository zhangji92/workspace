package com.gaoshen.wangfeng.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{

    private Button m4_but1,m4_but2,m4_but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        m4_but1= (Button) findViewById(R.id.m4_but1);
        m4_but2= (Button) findViewById(R.id.m4_but2);

        m4_but1.setOnClickListener(this);
        m4_but2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();

        /**
         * 给该Activity 设置启动模式为 SingleTask
         * SingleTask启动模式总结：
         * 情况1：当Activity 在栈中没有 ，创建一个Activity
         * 情况2：当Activity 处于栈顶时 ，不在创建新的Activity 实例
         * 情况3：当Activity 不处于栈顶位置时， 若想将之处于栈顶位置时 则先在栈中寻找该Activity 若在，将该Activity纸上的所有Activity 进行弹栈
         *   （ 如果已经存在一个task(工作，任务)与新activity亲和度（taskAffinity）一样，
         *    则activity将启动到该task。
         *  --------如果不是，才启动一个新task。同一个application里面，每个activity的taskAffinity默认都是一样的）
         *
         */
        if(id==m4_but1.getId()){
            Intent intent=new Intent(Main4Activity.this,Main4Activity.class);
            startActivity(intent);
        }else if(id==m4_but2.getId()){

            Intent intent=new Intent(Main4Activity.this,Main5Activity.class);
            startActivity(intent);
        }
    }
}
