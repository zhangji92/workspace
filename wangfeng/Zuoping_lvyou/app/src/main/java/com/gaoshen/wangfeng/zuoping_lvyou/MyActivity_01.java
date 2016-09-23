package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;

public class MyActivity_01 extends AppCompatActivity {

    private Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_01);

        ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() > 3 * 1000) {
                    ch.stop();
                    Intent intent = new Intent(MyActivity_01.this, MyActivity_02.class);
                    startActivity(intent);
                    //执行完一次，关闭
                    MyActivity_01.this.finish();
                }
            }
        });

    }

    public void imageClick(View view) {
        Intent intent = new Intent(MyActivity_01.this, MyActivity_02.class);
        startActivity(intent);
    }
}
