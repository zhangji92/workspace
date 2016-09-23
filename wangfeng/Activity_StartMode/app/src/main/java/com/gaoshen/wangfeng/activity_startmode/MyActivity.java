package com.gaoshen.wangfeng.activity_startmode;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.i("MyActivity.this", "----onCreate---");
        button1= (Button) findViewById(R.id.zt1);
        button2= (Button) findViewById(R.id.zt2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MyActivity.this", "----onStart---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MyActivity.this", "----onResume---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MyActivity.this", "----onPause---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MyActivity.this", "----onStop---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MyActivity.this", "----onRestart---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MyActivity.this", "----onDestroy---");
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.i("获取焦点或是去焦点","----输出该句话");
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * 保存数据
     * @param outState
     *
     * Activity被系统杀死时被调用
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("wf","保存的值");
        Log.i("保存数据","---------");
        super.onSaveInstanceState(outState);
    }

    /**
     * Activity被系统杀死后再重建的时候被调用-=
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String string= savedInstanceState.getString("wf","");
        Log.i("重新读取数据","---"+string);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
       int id= view.getId();
        if(id==button1.getId()){
            Intent intent=new Intent(MyActivity.this,DialogAactivity.class);
            startActivity(intent);
        }else if(id==button2.getId()){
            Intent intent=new Intent(MyActivity.this,MyActivity2.class);
            startActivity(intent);
        }
    }
}
