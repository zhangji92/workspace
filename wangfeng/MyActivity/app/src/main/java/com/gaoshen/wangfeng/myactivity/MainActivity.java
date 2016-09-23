package com.gaoshen.wangfeng.myactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import Mode.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,butFin,butIn,butIn2,butIn3,butIn4,butIn5,butIn6,butIn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//意思就是不在活动中显示
        //  标题栏,注意这句代码一定要在 setContentView()之前执行,不然会报错。
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.button);
        butFin= (Button) findViewById(R.id.finsh);
        butIn= (Button) findViewById(R.id.intent);
        butIn2= (Button) findViewById(R.id.intent2);
        butIn3= (Button) findViewById(R.id.intent3);
        butIn4= (Button) findViewById(R.id.intent4);
        butIn5= (Button) findViewById(R.id.intent5);
        butIn6= (Button) findViewById(R.id.intent6);
        butIn7= (Button) findViewById(R.id.intent7);
        button1.setOnClickListener(this);
        butFin.setOnClickListener(this);
        butIn.setOnClickListener(this);
        butIn2.setOnClickListener(this);
        butIn3.setOnClickListener(this);
        butIn4.setOnClickListener(this);
        butIn5.setOnClickListener(this);
        butIn6.setOnClickListener(this);
        butIn7.setOnClickListener(this);
    }

    public void toasl(){
        Toast.makeText(MainActivity.this,"xxx",Toast.LENGTH_SHORT).show();
    }
    public void toasl(String string){
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param view  被点击的 控件
     */
    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==button1.getId()){
            toasl();
        }else if(id==butFin.getId()){
            //清空一个Activtiy
            finish();//从栈中弹出该控件所在的Activity
        }else if(id==butIn.getId()){
            //点击跳转页面
            Intent intent=new Intent(MainActivity.this,MyActivity.class);
            startActivity(intent);
        }else if(id==butIn2.getId()){


            /**
             *  //启动隐式 Activity 在Manifest 中找 <cation>中 name为com.demo.android.ACTION_START 的Activity(进行匹配) category(类别)
             *
             * 通过匹配 <cation>中 name进行匹配 从而隐式的启动一个Activtiy
             */
            Intent intent=new Intent("com.demo.android.wangfeng");
            startActivity(intent);
        }
        else if(id==butIn3.getId()){


            /**
             *  //启动隐式 Activity 在Manifest 中找 <cation>中 name为com.demo.android.ACTION_START 的Activity(进行匹配) category(类别)
             *
             * 通过匹配 <cation>中 name进行匹配 从而隐式的启动一个Activtiy
             *
             * 如果有两个Activtiy的 <cation>和 <category>相同时 则进行选择
             *
             */
            Intent intent=new Intent("com.demo.android.wangfeng");
            //添加一个category 在Manifestz中进行匹配 categroy
            intent.addCategory("www.jige666.com");
            startActivity(intent);
        }else if(id==butIn4.getId()){
            /**
             * 通过隐式的方法 跳转一个网页
             */

        Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));

            startActivity(intent);
        }else if(id==butIn5.getId()){
            /**
             * 通过隐式的方法 跳转到拨号盘
             */
            Intent intent=new Intent();
            intent.setData(Uri.parse("tel:15148068726"));
            intent.setAction(Intent.ACTION_CALL);//设置一个action
            startActivity(intent);
        }else if(id==butIn6.getId()) {
            /**
             * 跳转页面传递一个对象数据
             */
            Intent intent = new Intent("com.android.wf");
            Bundle bn = new Bundle();
            User us = new User(1, "小明");
            bn.putSerializable("user", us);
            intent.putExtras(bn);
            startActivity(intent);
        }else if(id==butIn7.getId()){
            /**
             * 传递数据，接收回传值
             */
            Intent intent = new Intent("com.android.wf");
            Bundle bn = new Bundle();
            User us = new User(1, "小明");
            bn.putSerializable("user", us);
            intent.putExtras(bn);
           startActivityForResult(intent,1);
        }
    }

    /**
     * 获取回传参数
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    Bundle bundle=data.getExtras();
                    String str=bundle.getString("str");
                    Toast.makeText(this,str+"---",Toast.LENGTH_SHORT).show();
                }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 添加一个菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.title,menu);
        return true;
    }

    /**
     * ca
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int itemId= item.getItemId();
        if(itemId==R.id.add){
            toasl("add");
        }
       else if(itemId==R.id.delete){
            toasl("delete");
        }
        else if(itemId==R.id.update){
            toasl("update");
        }
        else if(itemId==R.id.select){
            toasl("select");
        }
        return super.onOptionsItemSelected(item);
    }
}
