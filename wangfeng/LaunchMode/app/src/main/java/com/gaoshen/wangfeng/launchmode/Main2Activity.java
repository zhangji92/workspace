package com.gaoshen.wangfeng.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button m2_but1,m2_but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        m2_but1= (Button) findViewById(R.id.m2_but1);
        m2_but1.setOnClickListener(this);
        m2_but2= (Button) findViewById(R.id.m2_but2);
        m2_but2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
           int id=view.getId();
        /**
         * SingleTop启动模式 总结：当该Activity 设定启动模式为SingleTop时
         * 情况1：该Activity 在栈顶时，若再一次启动该Activity 则不创建实例（不进行跳转）
         * 情况2：该ACtivity 不位于栈顶时 ，若再一次启动该Activity 则创建一个新的实例（启动一次创建一次）
         *
         */
        if(id==m2_but1.getId()){
            /**
             * 给Main2Activity 设置启动模式为SingleTop 若该Activity 位于栈顶 不重新创建该Activity 的实例
             */
            Intent intent=new Intent(Main2Activity.this,Main2Activity.class);
            intent.putExtra("str","今天是个好日子");
            startActivity(intent);

        } else if(id==m2_but2.getId()){
            /**
             * 若该Activity 不位于栈顶 重新创建该Activity 的实例
             */
            Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(intent);
        }
    }

    /**
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Intent intent1=getIntent();
        String str=intent1.getStringExtra("str");
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}
