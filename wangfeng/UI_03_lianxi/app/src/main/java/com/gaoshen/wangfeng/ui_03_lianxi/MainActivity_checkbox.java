package com.gaoshen.wangfeng.ui_03_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity_checkbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_checkbox);

    }
    public void butwf(View view){
        //是否被点击
        boolean check=((CheckBox)view).isChecked();

        String str;
        //动态获取 view的id
        switch (view.getId()){
            case R.id.check1:
                if(check){
                    str="恭喜您，回答正确";
                    Toast.makeText(MainActivity_checkbox.this,""+str,Toast.LENGTH_LONG).show();
                }else{
                    Log.i("xigua","no xigua");
                    str="不是你傻就是傻强傻";
                    Toast.makeText(MainActivity_checkbox.this,""+str,Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.check2:
                if (check){
                    str="傻强能不傻吗? 你个傻蛋";
                    Toast.makeText(MainActivity_checkbox.this,""+str,Toast.LENGTH_LONG).show();
                }else{
                    str="对喽，傻强坑定傻";
                    Toast.makeText(MainActivity_checkbox.this,""+str,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
