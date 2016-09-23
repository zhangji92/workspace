package com.gaoshen.wangfeng.contentresolver;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class My2Activity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);
        listView= (ListView) findViewById(R.id.list_view);
        addBtn= (Button) findViewById(R.id.but);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==addBtn.getId()){//添加
            add();
        }
    }


    /**
     * 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
     *
     * 这是后面插入data表的数据，只有执行空值插入，才能使插入的联系人在通讯录里可见
     */
    private  void add(){
        ContentResolver contentResolver= getContentResolver();
        ContentValues contentValues=new ContentValues();
        Uri rawUri= contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
        long rawContactId = ContentUris.parseId(rawUri);

        //往data表入姓名数据
        contentValues.clear();
        contentValues.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactId);
        contentValues.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        contentValues.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, "zhangsan");
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, contentValues);


//        //往data表入电话数据
//        contentValues.clear();
//        contentValues.put(android.provider.ContactsContract.Contacts.Data.RAW_CONTACT_ID, rawContactId);
//        contentValues.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//        contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "5554");
//        contentValues.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
//        getContentResolver().insert(
//                android.provider.ContactsContract.Data.CONTENT_URI, contentValues);
//
//        //往data表入Email数据
//        contentValues.clear();
//        contentValues.put(android.provider.ContactsContract.Contacts.Data.RAW_CONTACT_ID, rawContactId);
//        contentValues.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
//        contentValues.put(ContactsContract.CommonDataKinds.Email.DATA, "ljq218@126.com");
//        contentValues.put(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
//
//        getContentResolver().insert(
//                android.provider.ContactsContract.Data.CONTENT_URI, contentValues);

    }
}
