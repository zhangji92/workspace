package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class My_Activity_03 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m__activity_03);

        button = (Button) findViewById(R.id.button2tt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_Activity_03.this, MyActivity_04.class);
                startActivity(intent);
            }
        });
    }
}
