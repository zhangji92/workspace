package com.gaoshen.wangfeng.ui_03_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity_spinner extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_spinner);

        spinner=(Spinner) findViewById(R.id.spi);


        //创建适配器 ---  添加数据源到适配器       R.array.arr_spinner 自定义数据源   android.R.layout.simple_spinner_item默认布局
        ArrayAdapter arr_ad= ArrayAdapter.createFromResource(MyActivity_spinner.this,R.array.arr_spinner,android.R.layout.simple_spinner_item);
        arr_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //视图加载适配器
        spinner.setAdapter(arr_ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence str=((TextView)view).getText();
                Toast.makeText(MyActivity_spinner.this,str,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
