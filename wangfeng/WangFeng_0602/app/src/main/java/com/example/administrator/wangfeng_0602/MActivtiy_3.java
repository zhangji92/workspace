package com.example.administrator.wangfeng_0602;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MActivtiy_3 extends AppCompatActivity {

    TextView tex;
    Button but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mactivtiy_3);

         tex=new TextView(this);

        but=new Button(this);
        but.setText(R.string.but);
        but.setTextColor(ContextCompat.getColor(MActivtiy_3.this,R.color.red));
        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tex.setText(R.string.textname);
                tex.setTextSize(30);
                tex.setTextColor(ContextCompat.getColor(MActivtiy_3.this,R.color.red));
            }


        });


        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.addView(tex);
        linearLayout.addView(but);
        setContentView(linearLayout);
    }
}
