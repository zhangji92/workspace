package com.gaoshen.wangfeng.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends SQLiteOpenHelper{

    public MainActivity(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    /**
     * 创建数据库
     * 第一次创建的时候， 回调该方法
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建一个名为book的表
        String sql="create table book(name varchar,price int)";
        sqLiteDatabase.execSQL(sql);
    }


    /**
     *  修改数据库内容 （版本升级）  回调该方法
     * @param sqLiteDatabase 数据库实例
     * @param i  旧版本号
     * @param i1 新版本号
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
