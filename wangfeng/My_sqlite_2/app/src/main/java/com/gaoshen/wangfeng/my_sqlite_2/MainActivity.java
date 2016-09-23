package com.gaoshen.wangfeng.my_sqlite_2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySqLite ms=new MySqLite(this,"sqlite.db",null,1);
        SQLiteDatabase sqlite= ms.getReadableDatabase();
    }
}
