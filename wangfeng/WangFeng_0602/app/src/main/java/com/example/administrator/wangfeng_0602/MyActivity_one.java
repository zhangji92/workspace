package com.example.administrator.wangfeng_0602;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity_one extends AppCompatActivity {

    private Button but;
    private EditText edi;
    private TextView tex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_one);

        //初始化控件
        but = (Button) findViewById(R.id.button);
        edi = (EditText) findViewById(R.id.editText);
        tex = (TextView) findViewById(R.id.textView);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        String message = edi.getText().toString();
        if (message != null) {
            tex.setText(message);
            //从color.xml 中获取颜色
            tex.setTextColor(ContextCompat.getColor(MyActivity_one.this, R.color.Textcolor));
        }else{
            tex.setText("饿货，来杯咖啡吧！");
            tex.setTextColor(ContextCompat.getColor(MyActivity_one.this, R.color.red));
        }

    }

}
