package com.gaoshen.wangfeng.androidtext;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button insert,update,delete,select,selectOne;

    private List<Book> bookList;
    private ListView bookListView;
    private BaseAdapter bookAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert =(Button)findViewById(R.id.provider_insert);
        update =(Button) findViewById(R.id.provider_update);
        delete =(Button) findViewById(R.id.provider_delete);
        select =(Button) findViewById(R.id.provider_select);
        selectOne =(Button) findViewById(R.id.provider_select_one);

        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        select.setOnClickListener(this);
        selectOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId){

            case R.id.provider_insert:
                insertDateToTextChat(new Book("水浒传","施耐庵"));
                break;
            case R.id.provider_update:
                updateTextChatDate(2,new Book("西游记","罗贯中"));
                break;
            case R.id.provider_delete:
                deleteTextChatDate(2);
                break;
            case R.id.provider_select:
                selectAllTextChatDate();
                break;
            case R.id.provider_select_one:
                selectOneTextChatDate(4);
                break;
        }
    }
    private void insertDateToTextChat(Book book){
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookname",book.getBookName());
        contentValues.put("author",book.getBookauthor());
        Uri uri = contentResolver.insert(Uri.parse("content://com.gaoshen.wangfeng.customcontentprovider.provider/book"),contentValues);
        Log.e("insertDateToTextChat: ", "添加了一条：----"+uri);

        falshdate();
    }
    private void updateTextChatDate(int index,Book book){
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("author",book.getBookauthor());
        contentValues.put("bookname",book.getBookName());
        int res =0;
        if(index>=0){
            res = contentResolver.update(Uri.parse("content://com.gaoshen.wangfeng.customcontentprovider.provider/book/"+index),contentValues,null,null);
        }

        Log.e("updateTextChatDate: ","修改结果："+res );
        falshdate();
    }
    private void deleteTextChatDate(int index){
        ContentResolver contentResolver = getContentResolver();
        int res =0;
        if(index>=0){
            res = contentResolver.delete(Uri.parse("content://com.gaoshen.wangfeng.customcontentprovider.provider/book/"+index),null,null);
        }

        Log.e("updateTextChatDate: ","删除结果："+res );
        falshdate();
    }
    private void selectAllTextChatDate(){
        bookList.clear();
        List<Book> resList = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor corsor = contentResolver.query(Uri.parse("content://com.gaoshen.wangfeng.customcontentprovider.provider/book"),null,null,null,null);
        while(corsor.moveToNext()){
            int bookIdIndex = corsor.getColumnIndex("id");
            int bookNameIndex =corsor.getColumnIndex("bookname");
            int bookAuthorIndex = corsor.getColumnIndex("author");

            int bookId = corsor.getInt(bookIdIndex);
            String bookName = corsor.getString(bookNameIndex);
            String bookAuthor = corsor.getString(bookAuthorIndex);
            Book book = new Book(bookId,bookName,bookAuthor);
            resList.add(book);
            Log.e( "selectAllTextChatDate: ","查到书一本："+bookName +"    作者是："+bookAuthor+"   编号是："+bookId );
        }
        bookList.addAll(resList);
        initAdapter();
    }
    private void selectOneTextChatDate(int index){
        List<Book> resList = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor corsor=null;
        if(index>=0){
            corsor = contentResolver.query(Uri.parse("content://com.gaoshen.wangfeng.customcontentprovider.provider/book/"+index),null,null,null,null);
        }
        while(corsor.moveToNext()){
            int bookIdIndex = corsor.getColumnIndex("id");
            int bookNameIndex =corsor.getColumnIndex("bookname");
            int bookAuthorIndex = corsor.getColumnIndex("author");

            int bookId = corsor.getInt(bookIdIndex);
            String bookName = corsor.getString(bookNameIndex);
            String bookAuthor = corsor.getString(bookAuthorIndex);
            Book book = new Book(bookId,bookName,bookAuthor);
            resList.add(book);
            Log.e( "selectAllTextChatDate: ","查到书一本："+bookName +"    作者是："+bookAuthor+"   编号是："+bookId );
        }
        bookList.clear();
        bookList.addAll(resList);
        initAdapter();
    }

    private void initAdapter(){
        bookAdpater = new BaseAdapter() {
            @Override
            public int getCount() {
                return bookList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(MainActivity.this);
                Book book = bookList.get(position);
                text.setText("书名："+book.getBookName()+"  作者："+book.getBookauthor());
                return text;
            }
        };
        bookListView.setAdapter(bookAdpater);

    }
    /***
     * 刷新数据源
     */
    private void falshdate(){
        //刷新数据源
        selectAllTextChatDate();
        bookAdpater.notifyDataSetChanged();
    }
}
