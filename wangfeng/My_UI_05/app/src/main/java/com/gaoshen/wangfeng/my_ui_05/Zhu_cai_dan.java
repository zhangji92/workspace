package com.gaoshen.wangfeng.my_ui_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Zhu_cai_dan extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_cai_dan);

        assert toolbar!=null;
        assert  getSupportActionBar()!=null;

        //获取控件
        toolbar=(Toolbar)findViewById(R.id.Mytoolbar);
        setSupportActionBar(toolbar);
        //设置标题
        getSupportActionBar().setTitle("旅游");
        //toolbar.setSubtitle("子菜单");
        //图标
        toolbar.setLogo(R.drawable.weiqu);

        //设置导航栏图片
        toolbar.setNavigationIcon(R.drawable.xiaoyang);
        //设置导航栏图片




    }
}
