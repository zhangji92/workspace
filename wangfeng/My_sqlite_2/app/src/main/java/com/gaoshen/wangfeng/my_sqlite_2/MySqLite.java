package com.gaoshen.wangfeng.my_sqlite_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/17.
 */
public class MySqLite extends SQLiteOpenHelper {

    private Context mcontext;

    public MySqLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext=context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_BOOK = "create table book ("
                + "id integer primary key autoincrement, "
                + "author text, "
                + "price real, "
                + "pages integer, "
                + "name text)";
        sqLiteDatabase.execSQL(CREATE_BOOK);
        Toast.makeText(mcontext,"Create succeeded", Toast.LENGTH_SHORT).show();

    }
}
