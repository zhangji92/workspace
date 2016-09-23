package com.gaoshen.wangfeng.address_list;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import Mode.AddXingxi;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);


        editText1 = (EditText) findViewById(R.id.xm);
        editText2 = (EditText) findViewById(R.id.sj);
        editText3 = (EditText) findViewById(R.id.qq);


    }



    public void main(View view) {
        switch (view.getId()) {
            case R.id.quxiao:
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                break;
            case R.id.baocun:

                String name = editText1.getText().toString().replace(" ", "");
                String shouji = editText2.getText().toString().replace(" ", "");
                String qq = editText3.getText().toString().replace(" ", "");
                Intent intent = new Intent(MainActivity.this, My_list.class);
                if (!name.equals("") &&name!=null|| !shouji.equals("")&&shouji!=null) {

                    AddXingxi ad = new AddXingxi(name, shouji, qq);
                    SharedUtil.xieduixiang(this,"ad"+Applica.getI(),ad);
                    Applica.update();

                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"姓名或电话号不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)//获取手机返回键
        {
//            exitBy2Click(); //调用双击退出函数
            //退出
            DialogTc();

        }
        return false;
    }

    public void DialogTc(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("提示");
        builder.setMessage("是否退出记事本 ?");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedUtil.storeInt(MainActivity.this,"i",Applica.getI());
                Log.e("最后一个i的值","----"+Applica.getI());
                SysApplication.getInstance().exit();//退出程序
            }
        });
        builder.setNeutralButton("否",null);

        builder.create().show();
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
            tExit.schedule(new TimerTask() {//创建一个定时器
                @Override
                public void run() {
                    isExit = false; // 取消退出

                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            //退出系统时将最后一次i的值 写到文件

            finish();
            System.exit(0);


        }
    }
}
