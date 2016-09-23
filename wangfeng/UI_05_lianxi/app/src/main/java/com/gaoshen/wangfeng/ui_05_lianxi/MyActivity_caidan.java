package com.gaoshen.wangfeng.ui_05_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MyActivity_caidan extends AppCompatActivity {

    private Toolbar mytoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_caidan);

//        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mytoolbar);
        //设置主标题
//        getSupportActionBar().setTitle("my toolbar");
//        mytoolbar.setLogo(R.mipmap.ic_launcher);
        //设置字标题
//        mytoolbar.setSubtitle("字标题");
        //设置导航栏图片
//        mytoolbar.setNavigationIcon(R.drawable.xinsai);
        //导航栏图片 点击事件
//        mytoolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyActivity_caidan.this,"导航栏",Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    /**右侧菜单栏
     *获取 menu
     * @param menu 自定义的菜单栏
     * @return  true--> 添加菜单栏  false -->不添加菜单栏
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wang_menu, menu);
        return true;
    }

    /**右侧菜单栏  子菜单栏
     *
     * @param item 菜单栏中的每个item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.i4:
                tot("糯米");
                break;
            case R.id.i3:
                tot("收藏");
                break;
            case R.id.i2:
                tot("分享");
                break;
            case R.id.i1:
                tot("购物车");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //弹窗
    private void tot(String str) {
        Toast.makeText(MyActivity_caidan.this, str, Toast.LENGTH_SHORT).show();
    }
}
