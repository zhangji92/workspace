package com.androidui.app01.app01lianxi20160608;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void forwardPage(View view){
        switch (view.getId()){
            case R.id.t8:
                Intent intent = new Intent(MainActivity.this,MyCollectActivity.class);//我的收藏
                startActivity(intent);
                break;
            case R.id.t2:
                Toast.makeText(MainActivity.this,"t2",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
