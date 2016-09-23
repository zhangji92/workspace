package com.gaoshen.app.wangfeng0601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrator.wangfeng0530.R;

public class Main3Activity extends AppCompatActivity {

    private ToggleButton tb;
    private ImageView img;
    private ToggleButton tb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //初始化控件
        tb= (ToggleButton)findViewById(R.id.toggleButton);
        img= (ImageView) findViewById(R.id.imageView1);
        tb2= (ToggleButton)findViewById(R.id.toggleButton);


        /**
         * 给当前的tb设置监听器
         */
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            /**当点击 tb 的时候，当前的方法会执行
             *
             * @param buttonView-----代表当前被点击的控件本身
             * @param isChecked------代表被点击的控件状态
             *
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                    //当点击 tb 的时候，更换 img 的背景图片

                    //设置一个图片
                    img.setBackgroundResource(isChecked?R.drawable.wang:R.drawable.weixin);



            }
        });

    }




}
