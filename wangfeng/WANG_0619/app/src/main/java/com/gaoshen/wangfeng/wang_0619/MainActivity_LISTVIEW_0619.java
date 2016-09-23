package com.gaoshen.wangfeng.wang_0619;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity_LISTVIEW_0619 extends AppCompatActivity {

    private ListView listView;
    private int []icon={R.drawable.xiaoyang,R.drawable.xidapuben,R.drawable.xinsai};
    private String []iconName={"新疆旅游","广西旅游","内蒙古旅游"};
    private String []iconName_fs={"自由行","拼团游","骑马游"};
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>>dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__listview_0619);

       listView=(ListView) findViewById(R.id.wList);
        dataList = new ArrayList<Map<String, Object>>();
        simpleAdapter=new SimpleAdapter(MainActivity_LISTVIEW_0619.this,getData(),R.layout.item,new String[]{"image","text1","text2"},new int[]{R.id.wimg,R.id.wtext,R.id.wtext2});
        listView.setAdapter(simpleAdapter);
    }

    public List<Map<String,Object>> getData() {

        for (int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<>();

            map.put("image",icon[i]);
            map.put("text1",iconName[i]);
            map.put("text2",iconName_fs[i]);
            dataList.add(map);
        }

        return dataList;
    }

}
