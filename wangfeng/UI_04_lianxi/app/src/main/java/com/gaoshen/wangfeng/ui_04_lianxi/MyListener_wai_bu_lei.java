package com.gaoshen.wangfeng.ui_04_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyListener_wai_bu_lei extends AppCompatActivity {


    private Button button_wanbulei;


    //弹窗
    public void tot(String s) {
        Toast.makeText(MyListener_wai_bu_lei.this, s, Toast.LENGTH_SHORT).show();
    }

    /*弹窗*/
    public void tot2(MyListener_wai_bu_lei activity, CharSequence ch) {

        Toast.makeText(activity, ch, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listener_wai_bu_lei);

//        外部类实现监听事件
        button_wanbulei=(Button) findViewById(R.id.but_waibulei);

        button_wanbulei.setOnClickListener(new MyListener_weibulei2(MyListener_wai_bu_lei.this){
            @Override
            public void onClick(View v) {

                //修改透明度
               button_wanbulei.setAlpha(0.5f);
                super.onClick(v);
            }
        });



    }
}

class MyListener_weibulei2 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listener_weibulei2);
    }

    MyListener_wai_bu_lei myOn;

    public MyListener_weibulei2(MyListener_wai_bu_lei myOn) {
        this.myOn = myOn;
    }

    @Override
    public void onClick(View v) {

        Log.e("MyOnClistener", "我是外部类");
        myOn.tot2(myOn, "我是外部类");
    }
}




