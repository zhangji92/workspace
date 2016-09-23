package com.gaoshen.wangfeng.ui_03_lianxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity_stley extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_stley);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
//        TextView tt=(TextView) findViewById(R.id.textWf);
        EditText ed = (EditText) findViewById(R.id.editww);
//        tt.setText(str);
//        tt.setTextSize(40);
        ed.setText(str);
        ed.setTextSize(40);
    }
}
