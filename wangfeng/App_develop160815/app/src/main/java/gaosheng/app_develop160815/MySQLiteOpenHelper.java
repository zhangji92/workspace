package gaosheng.app_develop160815;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import gaosheng.util.ShareUtils;
import gaosheng.util.Student;

/**
 * Created by zhaofuqiang on 2016/8/16.
 *
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    /**
     * 第一次打开数据库执行
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table Book (id integer primary key autoincrement,author varcher,price double,totalpage integer,bookName varchar)";
        sqLiteDatabase.execSQL(sql);

    }

    /**
     * 更新数据库
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "create table Book2 (id integer primary key autoincrement,author varcher,price double,totalpage integer,bookName varchar)";
        sqLiteDatabase.execSQL(sql);


    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //openInput();
            //SharedPre();
            //testUtil();
            sqlite1();
        }


        /**
         * 创建SQLite数据库，进行数据的操作
         */
        public void sqlite1() {
            //获取SQLiteOpenHelper对象
            MySQLiteOpenHelper sqLiteText = new MySQLiteOpenHelper(this, "BookStorewf.db", null, 9);
            //获得SQLiteDatabase
            SQLiteDatabase sqLiteDatabase = sqLiteText.getReadableDatabase();
            //添加书籍1
            ContentValues contentValues1 = new ContentValues();
            contentValues1.put("author", "Tom");
            contentValues1.put("price", 23.5);
            contentValues1.put("totalpage", 200);
            contentValues1.put("bookname", "Tom写的书");
            //添加书籍2
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("author", "Jack");
            contentValues2.put("price", 50.5);
            contentValues2.put("totalpage", 100);
            contentValues2.put("bookname", "Jack写的书");
            //添加书籍3
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("author", "Kangkang");
            contentValues3.put("price", 100);
            contentValues3.put("totalpage", 234);
            contentValues3.put("bookname", "Kangkang写的书");
            //添加书籍4
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("author", "Jane");
            contentValues4.put("price", 123);
            contentValues4.put("totalpage", 234);
            contentValues4.put("bookname", "Jane写的书");
           /*向表中添加数据*/
            sqLiteDatabase.insert("Book", null, contentValues1);
            sqLiteDatabase.insert("Book", null, contentValues2);
            sqLiteDatabase.insert("Book", null, contentValues3);
            sqLiteDatabase.insert("Book", null, contentValues4);

            /*更新数据*/
            ContentValues updateValues = new ContentValues();
            updateValues.put("author", "Jane2");
            updateValues.put("bookname", "Jane2写的书");
            sqLiteDatabase.update("Book", updateValues, "id=?", new String[]{"4"});

           /*删除数据*/
//        ContentValues deleteValues = new ContentValues();
//        sqLiteDatabase.delete("Book","id>?",new String[]{"4"});


            //查询，返回游标集合
            Cursor cursor = sqLiteDatabase.query("Book", null, null, null, null, null, null);

            //判断是否有下一行
            while (cursor.moveToNext()) {
                /*获取指定列标识符*/
                int bid = cursor.getColumnIndex("id");
                int bauthor = cursor.getColumnIndex("author");
                int bprice = cursor.getColumnIndex("price");
                int btotalpage = cursor.getColumnIndex("totalpage");
                int bbookName = cursor.getColumnIndex("bookName");
                //通过index获取表中的数据
                int id = cursor.getInt(bid);
                String author = cursor.getString(bauthor);
                double price = cursor.getDouble(bprice);
                int totalpage = cursor.getInt(btotalpage);
                String bookName = cursor.getString(bbookName);

                Toast.makeText(this, id + "--" + author + "--" + price + "--" + totalpage + "--" + bookName, Toast.LENGTH_SHORT).show();

            }
            cursor.close();

        }
    }
}
