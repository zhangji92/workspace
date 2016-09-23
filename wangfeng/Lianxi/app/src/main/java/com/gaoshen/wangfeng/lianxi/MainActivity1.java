package com.gaoshen.wangfeng.lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity1 extends AppCompatActivity {

    private CheckBox ckb;
    private CheckBox ckb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        //初始化控件
        ckb=(CheckBox) findViewById(R.id.checkBox);
        ckb1=(CheckBox) findViewById(R.id.checkBox);

        //通过设置 ckb 的监听事件来看 ckb 是否被选中
        ckb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             *
             * @param buttonView
             * @param isChecked 判断是否被选中（true 或 flase）
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //通过onCheckedChanged来监听当前的 ckb 是否被点击
                if(isChecked){
                    Log.i("Mmmm",isChecked+"");
                }
            }
        });
    }
}
