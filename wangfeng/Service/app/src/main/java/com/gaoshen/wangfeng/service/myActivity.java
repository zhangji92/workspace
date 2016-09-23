package com.gaoshen.wangfeng.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class myActivity extends AppCompatActivity implements ServiceConnection{

    private Button button,button2,button3,button4,but_xia,but5,but6;
    private MyService.MyBind myBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        button= (Button) findViewById(R.id.but1);
        button2= (Button) findViewById(R.id.but2);
        button3= (Button) findViewById(R.id.but3);
        button4= (Button) findViewById(R.id.but4);
        but_xia= (Button) findViewById(R.id.but_xia);
        but5= (Button) findViewById(R.id.but5);
        but6=(Button) findViewById(R.id.but6);
    }

    public void dj(View view){
        int id=view.getId();
        Intent intent=new Intent(this,MyService.class);
        if(id==button.getId()){

            //可以创建多个服务，但只有一个实例
            startService(intent);//启动一个服务
        }else if(id==button2.getId()){
            //停止服务 停止的是服务的实例
            stopService(intent); //停止一个服务
        }else if(id==button3.getId()){
            //通过bind启动一个服务
            bindService(intent,this,BIND_AUTO_CREATE);
        } else if(id==button4.getId()){
            //通过bind停止服务
            unbindService(this);
        }else if(id==but_xia.getId()){
            //点击 进行下载
            myBind.rundown();
        }else if(id==but5.getId()){
            //启动一个IntentService
            Intent intent1=new Intent(this,MyIntentService_too.class);
            startService(intent1);
        }else if(id==but6.getId()){
            //停止一个IntentService
            Intent intent1=new Intent(this,MyIntentService_too.class);
            stopService(intent1);
        }

    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        myBind= (MyService.MyBind) iBinder;
        //启动以后调用  onServiceConnected
        Log.e("--------", "onServiceConnected" );
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

        Log.e("--------", "onServiceDisconnected");
    }
}
