package com.gaoshen.wangfeng.fragmentmode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 页面跳转
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, MyFragmentMode.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }

        }, 2000);
    }
}
