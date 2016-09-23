package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Xsxx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xsxx);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);
    }

    public void clickText_xs(View view) {
        switch (view.getId()) {
            case R.id.jian_xs:
                Intent intent1 = new Intent(Xsxx.this, MainActivity.class);//返回
                startActivity(intent1);
                break;

            case R.id.button_xs:
                Intent intent2 = new Intent(Xsxx.this, Xsxx_jieguo.class);//选修课程
                EditText ed=(EditText) findViewById(R.id.edit);
                String strEdit=ed.getText().toString();
                if(strEdit!=null&&!strEdit.equals("")){
                    intent2.putExtra("strEdit",strEdit);
                    startActivity(intent2);
                }else{
                    Toast.makeText(Xsxx.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
