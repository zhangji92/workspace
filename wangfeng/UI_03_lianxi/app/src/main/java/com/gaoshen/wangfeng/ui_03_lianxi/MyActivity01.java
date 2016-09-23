package com.gaoshen.wangfeng.ui_03_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MyActivity01 extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my01);

        /**
         * 只支持选择一次
         */
        //初始化控件
        autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoC);
        //初始化数据源
        String [] res=getResources().getStringArray(R.array.arr_name);
        //创建一个适配器
        ArrayAdapter<String> arrAdp=new ArrayAdapter<String>(MyActivity01.this,android.R.layout.simple_list_item_1,res);
        //将控件与适配器进行绑定 
        autoCompleteTextView.setAdapter(arrAdp);


        /**
         * 支持多选择的
         */
        //初始化控件
        multiAutoCompleteTextView=(MultiAutoCompleteTextView) findViewById(R.id.MultiC);
        multiAutoCompleteTextView.setAdapter(arrAdp);
        //设置以逗号 为分隔符
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
