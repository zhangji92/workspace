package com.gaoshen.wangfeng.filestorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import Mode.Wangfeng;
import Mode.Wangfeng2;

/**
 * Created by Administrator on 2016/8/16.
 */
public class SharedPerferences_shouci extends AppCompatActivity {

   private Context context=SharedPerferences_shouci.this;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedperferences);

//        //存储数据
//        SharedPreferences sharedPreferences= getSharedPreferences("textPer",0);
//        SharedPreferences.Editor edit= sharedPreferences.edit();
//
//        edit=edit.putString("str","Hello SharedPreferences.Editor");
//        edit=edit.putBoolean("zhi",true);
//        edit.commit();
//
//
////        删除数据
////        edit=edit.remove("zhi");
////        edit.commit();
//
//        //读取数据
//       String strZi= sharedPreferences.getString("str","默认值");
//       Boolean ba= sharedPreferences.getBoolean("zhi",false);
//
//        Toast.makeText(SharedPerferences_shouci.this,"存储字符串    "+strZi,Toast.LENGTH_SHORT).show();
//        Toast.makeText(SharedPerferences_shouci.this,"存储boolean   "+ba,Toast.LENGTH_SHORT).show();
//
//        //字符串存储数据
//        SharedUtil.storeString(context,"str1","大家好");
//        String str=SharedUtil.getString(context,"str","默认值");
//        textView1= (TextView) findViewById(R.id.t1);
//        textView1.setText("字符串  :"+str);
//
//        //int存储数据
//        SharedUtil.storeInt(context,"str2",5280);
//        int i=SharedUtil.getInt(context,"str2",0);
//        textView2= (TextView) findViewById(R.id.t2);
//        textView2.setText("int  :"+i);
//        //long存储数据
//        SharedUtil.storeLong(context,"str3",1111111111);
//        long l=SharedUtil.getLong(context,"str3",0);
//        textView3= (TextView) findViewById(R.id.t3);
//        textView3.setText("long  :"+l);
//        //boolean存储数据
//        SharedUtil.storeBoolean(context,"str3",true);
//
//        SharedUtil.remove(context,"str3");//删除
//        boolean b=SharedUtil.getBoolean(context,"str3",false);
//
//        textView4= (TextView) findViewById(R.id.t4);
//        textView4.setText("Boolean  :"+b);

        //对象
        //写对象
        Wangfeng wf=new Wangfeng();
        Wangfeng2 wf2=new Wangfeng2();
        SharedUtil.xieduixiang(context,"obj",wf);
//        SharedUtil.remove(context,"obj");//删除对象
        Wangfeng strobj= (Wangfeng) SharedUtil.duduixiang(context,"obj",null);
        textView5= (TextView) findViewById(R.id.t5);
        textView5.setText("对象  :"+strobj.nameGet());




    }



}
