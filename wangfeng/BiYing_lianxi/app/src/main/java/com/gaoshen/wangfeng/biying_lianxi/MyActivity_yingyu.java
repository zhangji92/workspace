package com.gaoshen.wangfeng.biying_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MyActivity_yingyu extends AppCompatActivity {

    private Toolbar tob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_yingyu);

        tob=(Toolbar) findViewById(R.id.toolbary);
        setSupportActionBar(tob);
        tob.setNavigationIcon(R.drawable.wang1);
        tob.setLogo(R.drawable.wang2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.yingyu_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
