package com.gaoshen.wangfeng.sqlite_lianxi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/17.
 */
public class SqLite extends SQLiteOpenHelper {


    public SqLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table Book(id int primary key,author varchar,price int,totalpage int,bookname vatchar)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql="create table category(cid int primary key,catename varchar)";
        sqLiteDatabase.execSQL(sql);

    }
}
