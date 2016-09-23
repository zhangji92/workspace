package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyActivity_wo_de extends AppCompatActivity {

    private Toolbar toolbarlist;
    private ListView listView_list;
    private int[] icon = {R.drawable.sou1, R.drawable.sou2, R.drawable.sou3};
    private String[] iconName = {"乌鲁木齐五日游", "怪石域七日游", "交河古城三日游"};
    private String[] strings_text1 = {"自由行", "拼团游", "参团游"};
    private String[] strings_text2 = {"￥3000.00起", "￥2999.00起", "￥2500.00起"};
    private String[] strings_text3 = {"2015-04-26出发","2015-04-26出发","2015-04-26出发"};
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_wo_de);

        listView_list=(ListView) findViewById(R.id.listView_l);

        toolbarlist = (Toolbar) findViewById(R.id.toolbar_list);
        setSupportActionBar(toolbarlist);

        getSupportActionBar().setTitle("我的收藏");
        toolbarlist.setSubtitle("王锋");
        toolbarlist.setNavigationIcon(R.drawable.jian_tou);
        toolbarlist.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity_wo_de.this, MyActivity_02.class);
            }
        });

        dataList=new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(MyActivity_wo_de.this, getDate(), R.layout.item_list,
                new String[]{"img", "iconame", "text1", "text2", "text3"},
                new int[]{R.id.imageList,R.id.text01,R.id.text02,R.id.text03,R.id.text04});

        listView_list.setAdapter(simpleAdapter);
    }

    public  List<Map<String, Object>> getDate() {
        for (int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<>();
            map.put("img",icon[i]);
            map.put("iconame",iconName[i]);
            map.put("text1",strings_text1[i]);
            map.put("text2",strings_text2[i]);
            map.put("text3",strings_text3[i]);

            dataList.add(map);
        }
        return dataList;
    }
}
