package com.gaoshen.wangfeng.myactivtiy;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button butt;
    private EditText edit;
    private TextView text;
    private  String magess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text=(TextView) findViewById(R.id.textView2);

        Intent intent=getIntent();
        String textValue=intent.getStringExtra("str");
        text.setText("1的消息:"+textValue);
        text.setTextColor(ContextCompat.getColor(MainActivity2.this,R.color.font2));


        /** 第二个页面在 点击 butt 时给第一个页面回传一个数据
         *  回传到第一个页面的实际上是一个intent对象
         */
        butt=(Button) findViewById(R.id.button2);
        edit=(EditText)findViewById(R.id.edit2);


        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前edit 的值
                magess=edit.getText().toString().trim();

                //不进行跳转，只进行回传数据
                Intent data=new Intent();
                data.putExtra("data",magess);
                //通过 setResult 将 data 回传给第一个页面  2代表当前页的返回码
                setResult(2,data);

                //结束当前页面
                finish();
            }
        });


    }
}
