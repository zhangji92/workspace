package com.gaoshen.wangfeng.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ReFlashListView.IReflashListener{


    private ReFlashListView listView;

    List<Mode> list= new ArrayList<>();
    MyAdapter  myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lists();//加载初始数据
        showListView(list);

    }

    public void showListView(List<Mode> list){
        if(myAdapter==null){//myAdapter为空的话
            listView = (ReFlashListView) findViewById(R.id.list_xiala);

            myAdapter=new MyAdapter(MainActivity.this,list);
            listView.setAdapter(myAdapter);
            listView.setInterface(this);//获取到listView的时候，给他设置一个接口
        }else{
            myAdapter.onDataChange(list);
        }
    }

    /**
     * 数据源
     * @return
     */
    public List<Mode>lists(){

        for (int i = 0; i < 6; i++) {

            list.add(new Mode("这就是我的年代", "我的未来"));
        }
        return list;
    }


    /**
     * 调用该方法时 向list中添加数据
     */
    public void listsx() {

        for (int i = 0; i < 2; i++) {
            Mode mo = new Mode("刷新数据", "内容" + i);
            list.add(0, mo);//将数据添加 到最上面
        }

    }


    /**
     * 添加数据后刷新
     */
    @Override
    public void onReflash() {

                //获取最新数据
                listsx();
                //通知界面显示数据
                showListView(list);
                // 刷新数据完毕 通知listView
                listView.reflashComplete();

    }


}

