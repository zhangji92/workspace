package com.gaoshen.wangfeng.customcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/9/19.
 */
public class MyContentProvder extends ContentProvider {

    public static final int BOOK_DIR = 0;
    public static final int BOOK_ONE = 1;
//    public static final int TABLE2_DIR = 2;
//    public static final int TABLE2_ITEM = 3;
    public static final String AUTHORITIES="com.gaoshen.wangfeng.customcontentprovider.provider";
    private static UriMatcher uriMatcher;
    private MySqLite mySqLite;

    static {
        uriMatcher =new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITIES,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITIES,"book/#",BOOK_ONE);
    }

    /**
     * ContentProvider 创建后被调用
     * @return
     */
    @Override
    public boolean onCreate() {
        try {
            //创建数据库
            mySqLite = new MySqLite(getContext(),"book.db",null,1);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    /**根据Uri查询出selection指定的条件所匹配的全部记录， 并且可以指定查询那些列 以及什么方式排序
     *
     * @param uri
     * @param strings
     * @param s
     * @param strings1
     * @param s1
     * @return
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {

        SQLiteDatabase database=mySqLite.getReadableDatabase();
        Cursor cursor;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR://查询所有数据
                cursor=database.query("book",strings,s,strings1,null,null,s1);
                return cursor;
            case BOOK_ONE://查询单条数据(指定)
                String bookId=uri.getPathSegments().get(1);
                cursor=database.query("book",strings,"id=?",new String[]{bookId},null,null,s1);
                return cursor;
            default:
                return null;
        }

    }

    /**
     * 返回当前Uri的MIME类型，如果该Uri对应的数据可能包括多条数据，那么MIME类型字符串 就是以Vnd.android.dir 开头
     * 如果该Uri对应的数据只有一条记录 该MIME类型字符串 就是以vnd,android.cursor.item/开头
     * @param uri
     * @return
     */
    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:  //Uri对应的数据可能包括多条数据,MIME类型字符串 就是以Vnd.android.dir 开头
                return "vnd.android.cursor.dir/vnd."+AUTHORITIES+".book";
            case BOOK_ONE: //Uri对应的数据只有一条记录,该MIME类型字符串 就是以vnd,android.cursor.item/开头
                return "vnd.android.cursor.item/vnd."+AUTHORITIES+".book";
            default:
                return null;
        }
    }

    /**根据Uri插入Values对应的数据
     *
     * @param uri
     * @param contentValues
     * @return
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase database=mySqLite.getReadableDatabase();
        long id=database.insert("book",null,contentValues);
        String insert_id="content://"+AUTHORITIES+"/book/"+id;
        Uri uri1=Uri.parse(insert_id);
        return uri1;
    }

    /**
     * 根据Uri删除 selection指定的条件  所匹配的全部记录
     * @param uri
     * @param s
     * @param strings
     * @return
     */
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        SQLiteDatabase database=mySqLite.getReadableDatabase();
        int deleteRes=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRes=database.delete("book",s,strings);
                return deleteRes;
            case BOOK_ONE:
                String bookId=uri.getPathSegments().get(1);
                deleteRes=database.delete("book","id=?",new String[]{bookId});
                return deleteRes;
            default:
                return 0;
        }
    }

    /**
     * 根据Uri修改  selection指定的条件 所匹配的全部记录
     * @param uri
     * @param contentValues
     * @param s
     * @param strings
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
       SQLiteDatabase database=mySqLite.getReadableDatabase();
        int updateRes=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRes=database.update("book",contentValues,s,strings);
                return updateRes;
            case BOOK_ONE:
                String bookId=uri.getPathSegments().get(1);
                updateRes=database.update("book",contentValues,"id=?",new String[]{bookId});
                return updateRes;
            default:
                return 0;
        }
    }

}

/**
 * 数据库
 */
class MySqLite extends SQLiteOpenHelper {

    private String sql ="create table book(id integer primary key autoincrement,bookname varchar,author varchar)";

    public MySqLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}