package com.gaoshen.wangfeng.my_application_guoyan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tuichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);
    }
    public void clickText1(View view) {
        switch (view.getId()) {
            case R.id.text1:
                Intent intent1=new Intent(MainActivity.this,Xxkc.class);//选修课程
                startActivity(intent1);
                break;
            case R.id.text2:
                Intent intent2=new Intent(MainActivity.this,Kcxx.class);
                intent2.putExtra("what","ss");
                //课程信息
                startActivity(intent2);

                break;

            case R.id.text3:
                Intent intent3=new Intent(MainActivity.this,Xsxx.class);  //查询学生信息
                startActivity(intent3);
                break;

            case R.id.text4:
                Intent intent4=new Intent(MainActivity.this,Kcxx.class);  //课程详细信息
                startActivity(intent4);
                break;

            case R.id.text5:
                Intent intent5=new Intent(MainActivity.this,Bz.class);  //帮助
                startActivity(intent5);
                break;

            case R.id.text6:
                 //退出
                DialogTc();
                break;
        }
    }

    public void DialogTc(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("退出系统");
        builder.setMessage("是否退出系统 ?");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SysApplication.getInstance().exit();//退出程序
            }
        });
        builder.setNeutralButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)//获取手机返回键
        {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {//创建一个定时器78
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

}
