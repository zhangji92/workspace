package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MyActivity_04 extends AppCompatActivity {

    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_04);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar_01);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle(R.string.title);
        toolbar1.setNavigationIcon(R.drawable.jian_tou);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MyActivity_04.this,My_Activity_03.class);
                startActivity(intent);
            }
        });
    }
    public void clickQ(View view){
        Intent intent =new Intent(MyActivity_04.this,My_Activity_03.class);
        startActivity(intent);
    }


}
