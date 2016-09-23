package com.gaoshen.wangfeng.wang_dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_zidingyi extends AppCompatActivity {

    private Button button_dl;
    private Button button_zc;
    private EditText editText_yh;
    private EditText editText_ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_zidingyi);

        button_dl=(Button) findViewById(R.id.but_dl);
        button_zc=(Button) findViewById(R.id.but_zc);
        editText_yh=(EditText)findViewById(R.id.edi_yh);
        editText_ma=(EditText)findViewById(R.id.edi_ma);

        button_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText_yh.getText().toString().trim().replace(" ","");
                String pass=editText_ma.getText().toString().trim().replace(" ","");
                if("傻强".equals(name) && "222".equals(pass)){
                    Toast.makeText(MainActivity_zidingyi.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity_zidingyi.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
