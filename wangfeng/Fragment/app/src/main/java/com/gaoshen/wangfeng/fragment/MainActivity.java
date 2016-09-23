package com.gaoshen.wangfeng.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4,butInt;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("---创建Activity","---onCreate");
        setContentView(R.layout.activity_main);

        button1= (Button) findViewById(R.id.add);
        button2= (Button) findViewById(R.id.insert);
        button3= (Button) findViewById(R.id.rep);
        button4= (Button) findViewById(R.id.remo);
        butInt= (Button) findViewById(R.id.intent);
        frameLayout= (FrameLayout) findViewById(R.id.frame);

    }

    public void setOnclick(View view){
//
        int id=view.getId();
        if(id==button1.getId()){
            //添加
            LeftFargment  lf=new LeftFargment();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.frame,lf,"add");
                ft.commit();
        }else if(id==button2.getId()){
            //查询
            FragmentManager fm=getSupportFragmentManager();
            Fragment fragment= fm.findFragmentByTag("add");
            if(fragment != null){
             String str= fragment.getTag();
                Toast.makeText(this,"找到了"+str,Toast.LENGTH_SHORT).show();
          }else {
                Toast.makeText(this,"没有找到fragment",Toast.LENGTH_SHORT).show();
            }
        }else if(id==button3.getId()){
            //替换
            Left2 l2=new Left2();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.frame,l2);
            ft.addToBackStack(null);
            ft.commit();
        }else if(id==button4.getId()){
            //删除
            FragmentManager fm=getSupportFragmentManager();
            Fragment fragment= fm.findFragmentByTag("add");
            if(fragment != null) {
               FragmentTransaction ft= fm.beginTransaction();
                ft.remove(fragment);
                ft.commit();
            }else {
                Toast.makeText(this, "您删除的内容不存在", Toast.LENGTH_SHORT).show();
            }
        }else if(id==butInt.getId()){
            Intent intent=new Intent("com.wf.jg666");
            startActivity(intent);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("---启动Activity","---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("---恢复Activity","---onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("---暂停Activity","---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("---停止Activity","---onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("---销毁Activity","---onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("---重新开始Activity","---onStop");
    }
}
