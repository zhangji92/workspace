package com.gaoshen.wangfeng.sqlite_lianxi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

public class MySQlite extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sqlite);

        textView1= (TextView) findViewById(R.id.tt1);
        textView2= (TextView) findViewById(R.id.tt2);
        textView3= (TextView) findViewById(R.id.tt3);
        textView4= (TextView) findViewById(R.id.tt4);
        textView5= (TextView) findViewById(R.id.tt5);


        //创建数据库
        SqLite sqLite=new SqLite(MySQlite.this,"BookStore2.db",null,6);
        SQLiteDatabase sqLiteDatabase=sqLite.getReadableDatabase();
        /**
         * contenvalues只能存储基本类型的数据，像string，int之类的，不能存储对象这种东西
         *
         * 在往数据库中插入数据的时候，首先应该有一个ContentValues的对像
         */
        ContentValues contentValues1=new ContentValues();
        contentValues1.put("id",1);
        contentValues1.put("author","王锋");
        contentValues1.put("price",56);
        contentValues1.put("totalpage",266);
        contentValues1.put("bookname","西游记");
        sqLiteDatabase.insert("Book",null,contentValues1);

        ContentValues contentValues2=new ContentValues();
        contentValues2.put("id",2);
        contentValues2.put("author","傻强");
        contentValues2.put("price",56);
        contentValues2.put("totalpage",266);
        contentValues2.put("bookname","哈哈哈");
        sqLiteDatabase.insert("Book",null,contentValues2);

        ContentValues contentValues3=new ContentValues();
        contentValues3.put("cid",1);
        contentValues3.put("catename","文献类");
        sqLiteDatabase.insert("category",null,contentValues3);



        //创建一个游标
        Cursor cursor=sqLiteDatabase.query("Book",null,null,null,null,null,null);


        String string1="";
        int in3=0;
        int in4=0;int in1=0;
        String string5="";
        while(cursor.moveToNext()){
            int index1=cursor.getColumnIndex("id");
            int index2=cursor.getColumnIndex("author");
            int index3=cursor.getColumnIndex("price");
            int index4=cursor.getColumnIndex("totalpage");
            int index5=cursor.getColumnIndex("bookname");
             in1= cursor.getInt(index1);
            string1=cursor.getString(index2);
            in3= cursor.getInt(index3);
            in4= cursor.getInt(index4);
            string5=cursor.getString(index5);
        }

        textView1.setText("id--"+in1);
        textView2.setText("author--"+string1);
        textView3.setText("price--"+ in3);
        textView4.setText("totalpage--"+in4);
        textView5.setText("bookname--"+string5);


        int n2=0;
        String s2="";
        Cursor cursor2=sqLiteDatabase.query("category",null,null,null,null,null,null);
        while(cursor2.moveToNext()){
            int index1=cursor2.getColumnIndex("cid");
            int index2=cursor2.getColumnIndex("catename");

            n2= cursor2.getInt(index1);
            s2=cursor2.getString(index2);
            Toast.makeText(this,n2+"---"+s2,Toast.LENGTH_SHORT).show();
        }

    }
}
