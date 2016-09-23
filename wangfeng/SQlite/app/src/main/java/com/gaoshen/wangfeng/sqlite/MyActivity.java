package com.gaoshen.wangfeng.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        textView1= (TextView) findViewById(R.id.txt1);
        textView2= (TextView) findViewById(R.id.txt2);

        //第二个参数是数据库  第三个是游标  第四个是版本
        MainActivity ma=new MainActivity(this,"sqLite.db",null,2);
        SQLiteDatabase sqlite= ma.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name","双城记");
        values.put("name","格列佛游记");
        values.put("price",150);
        values.put("price",175);
        sqlite.insert("book",null,values);

        //
        Cursor cursor=sqlite.query("book",null,null,null,null,null,null);
        int val=0;
        String string="";
        List<String> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        while(cursor.moveToNext()){
            //获取指定列 字段的索引
            int index=cursor.getColumnIndex("name");
            //通过指定 索引 查询该字段的值
            string=cursor.getString(index);
            list.add(string);
           int index2 =cursor.getColumnIndex("price");
            val=cursor.getInt(index2);
list2.add(val);
//
        }
        String str="";
        for(int i=0;i<list.size();i++){
             str+=list.get(i);
        }
        int x=0;
        for(int i=0;i<list2.size();i++){
            x+=list2.get(i);
            textView2.setText(String.valueOf(x));
        }
        textView1.setText(str);

        cursor.close();

    }
}
