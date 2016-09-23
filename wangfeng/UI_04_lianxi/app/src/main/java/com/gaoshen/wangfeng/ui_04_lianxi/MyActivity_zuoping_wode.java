package com.gaoshen.wangfeng.ui_04_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyActivity_zuoping_wode extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.drawable.sou1, R.drawable.sou2, R.drawable.sou3};
    private String[] iconName = {"乌鲁木齐五日游", "怪石峪三日游", "交河故城3日游"};
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_zuoping_wode);

        listView = (ListView) findViewById(R.id.List_View);
//        1.准备数据源
        //2.新建适配器
//        3.Liatview 加载适配器
//        4.配置事件监听器
        dataList = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(MyActivity_zuoping_wode.this, getData(), R.layout.item, new String[]{"image", "text"}, new int[]{R.id.imageitem, R.id.textitem});
        listView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        for (int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }

        return dataList;
    }
}
