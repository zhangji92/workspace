package com.gaoshen.wangfeng.address_list;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Mode.AddXingxi;

public class My_list extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<AddXingxi> list = new ArrayList<>();
    private LayoutInflater layoutInflater;

    private Toolbar tl;
    private BaseAdapter baseAdapter;
    private AddXingxi ax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        //添加本类Activity 到结束App类
        SysApplication.getInstance().addActivity(this);

        for (int i = 1; ; i++) {
            //从指定文件获取数据源
             ax = (AddXingxi) SharedUtil.duduixiang(this, "ad" + i, null);
            Log.e("----读取对象----", "-----------------" + i);
            if (ax != null) {
                list.add(ax);

                Log.e("----读取对象----" + i, "-----------------" + ax.getName());
            } else {
                break;
            }
        }





        layoutInflater = this.getLayoutInflater();//初始化layoutInflate


        listView = (ListView) findViewById(R.id.dianhua);//绑定listView控件



        listView.setAdapter(base());//绑定适配器


        //删除
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view,final int j, long l) {
//
//
//                new AlertDialog.Builder(My_list.this).setTitle("提示").setMessage("是否要删除").setNeutralButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String str = list.get(j).getName();
//                        SharedUtil.remove(My_list.this, "ad" + j);
//                        Toast.makeText(My_list.this, "ad--remove" + j, Toast.LENGTH_SHORT).show();
//
//                        Log.e("删除数据---" +i, "name--" + str);
//
//                        baseAdapter.notifyDataSetChanged();
//                    }
//                }).show();
//
//                return true;
//            }
//        });




        listView.setOnItemClickListener(this);
    }

    public BaseAdapter base() {
        baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View viewW = layoutInflater.inflate(R.layout.activity_yangqing, null);

                //姓名
                TextView t1 = (TextView) viewW.findViewById(R.id.x_name);
                t1.setText(list.get(i).getName());
                //电话号码
                TextView t2 = (TextView) viewW.findViewById(R.id.x_shouji);
                t2.setText(list.get(i).getHaoMa());
                //qq号
                TextView t3 = (TextView) viewW.findViewById(R.id.x_qq);
                t3.setText(list.get(i).getQq());


                return viewW;
            }
        };
        return baseAdapter;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AddXingxi ax = list.get(i);

        Uri uri = Uri.parse("tel:" + ax.getHaoMa());
        Intent in = new Intent();
        in.setAction(Intent.ACTION_DIAL);
        in.setData(uri);
        startActivity(in);

    }


    //点击跳转页面
    public void tiaoz(View view) {
        switch (view.getId()) {
            case R.id.tianjia:
                Intent intent = new Intent(My_list.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
