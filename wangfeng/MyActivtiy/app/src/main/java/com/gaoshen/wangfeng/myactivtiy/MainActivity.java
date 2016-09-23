package com.gaoshen.wangfeng.myactivtiy;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edi;
    private Button but;
    private String  ediValues;
    private TextView tex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         edi=(EditText)findViewById(R.id.edit);
        but=(Button) findViewById(R.id.button);
        tex=(TextView) findViewById(R.id.textView);


        /**
         * 通过startActivtiyForResult
         */
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ediValues=edi.getText().toString();
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("str", ediValues);


                /** 通过startActitiyForResult 跳转
                 *
                 * 第一个参数是Intent对象
                 * 第二个参数是一个标识  1代表当前页的请求码
                 *
                 */
                //startActivityForResult(intent,1);  一种有回传值得 启动Activtity 方法
                startActivityForResult(intent,1);
                StringBuffer sb=new StringBuffer();
                sb.append("我:"+ediValues);
            }
        });
    }

    /**通过onActivityResult,  接收返回数据的方法
     *  requestCode：请求的标识
     *  resultCode ：第二个页面返回的标识
     *  data:第二个页面回传的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //当请求码 == 1 ， 返回码 ==2  执行如下代码
        if(requestCode==1 && resultCode==2){
            String content=data.getStringExtra("data");
            StringBuffer sb=new StringBuffer();
            sb.append(content);
            tex.setText("2的消息:"+content);
            tex.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.font1));
        }
    }
}
