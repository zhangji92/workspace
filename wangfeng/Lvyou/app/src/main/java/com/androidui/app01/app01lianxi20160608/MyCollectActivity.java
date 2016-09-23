package com.androidui.app01.app01lianxi20160608;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.view.ViewGroup.*;
import android.widget.TextView;

import com.androidui.app01.mode.MyCollect;

import org.joda.time.DateTime;

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyCollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);

//        工具栏
        Toolbar myToolbar = (Toolbar) findViewById(R.id.myTooblar);
        assert myToolbar != null;
        myToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCollectActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

//收藏内容列表
        final ListView collect = (ListView) findViewById(R.id.collectList);

        BaseAdapter collectAdapter = new BaseAdapter() {
            @Override
            public int getCount() {

                return collects().size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                RelativeLayout c1 = new RelativeLayout(MyCollectActivity.this);//最外围布局

                View blueLine1 = new View(MyCollectActivity.this);//水平线
                blueLine1.setId(View.generateViewId());
                blueLine1.setBackgroundResource(R.color.toolbarBackground);
                RelativeLayout.LayoutParams blueLine1Params=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,1);
                blueLine1.setLayoutParams(blueLine1Params);

                ImageView hongdenglong = new ImageView(MyCollectActivity.this);//图片
                hongdenglong.setId(View.generateViewId());
                hongdenglong.setImageResource(collects().get(position).getImage());
                hongdenglong.setPadding(20,0,30,10);
                RelativeLayout.LayoutParams hongdenglongParams=new RelativeLayout.LayoutParams(250,250);
                hongdenglongParams.addRule(RelativeLayout.BELOW,blueLine1.getId());
                hongdenglong.setLayoutParams(hongdenglongParams);
                c1.addView(hongdenglong);


                TextView t1 = new TextView(MyCollectActivity.this);//标题1
                t1.setId(View.generateViewId());
                t1.setText(collects().get(position).getTitle());
                t1.setPadding(0,20,0,10);
                t1.setTextColor( ContextCompat.getColor(t1.getContext(),R.color.black));
                RelativeLayout.LayoutParams t1Params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                t1Params.addRule(RelativeLayout.RIGHT_OF,hongdenglong.getId());
                t1.setLayoutParams(t1Params);
                c1.addView(t1);

                TextView t2 = new TextView(MyCollectActivity.this);//标题2
                t2.setId(View.generateViewId());
                t2.setPadding(20,20,0,10);
                t2.setText(collects().get(position).getWhatWay());
                t2.setTextColor( ContextCompat.getColor(t1.getContext(),R.color.myCollect));
                t2.setBackgroundResource(R.drawable.titbackground);
                RelativeLayout.LayoutParams t2Params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                t2Params.addRule(RelativeLayout.BELOW,t1.getId());
                t2Params.addRule(RelativeLayout.RIGHT_OF,hongdenglong.getId());
                t2.setLayoutParams(t2Params);
                c1.addView(t2);

                TextView t3 = new TextView(MyCollectActivity.this);//标题3
                t3.setId(View.generateViewId());
                t3.setPadding(0,20,0,10);
                DecimalFormat nf = new DecimalFormat("###.00");
                String testStr = nf.format(collects().get(position).getPrice());
                t3.setText("￥"+testStr+"起");
                t3.setTextColor( ContextCompat.getColor(t1.getContext(),R.color.tit3Color));
                RelativeLayout.LayoutParams t3Params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                t3Params.addRule(RelativeLayout.BELOW,t2.getId());
                t3Params.addRule(RelativeLayout.RIGHT_OF,hongdenglong.getId());
                t3.setLayoutParams(t3Params);
                c1.addView(t3);

                TextView t4 = new TextView(MyCollectActivity.this);//标题4
                t4.setId(View.generateViewId());
                t4.setPadding(0,0,30,0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(collects().get(position).getGoDate());
                t4.setText(date+"出发");
                t4.setTextColor( ContextCompat.getColor(t1.getContext(),R.color.tit4Color));
                RelativeLayout.LayoutParams t4Params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                t4Params.addRule(RelativeLayout.BELOW,t3.getId());
                t4Params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                t4.setLayoutParams(t4Params);
                c1.addView(t4);




                View blueLine = new View(MyCollectActivity.this);//水平线
                blueLine.setId(View.generateViewId());
                blueLine.setBackgroundResource(R.color.toolbarBackground);
                RelativeLayout.LayoutParams buParam=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,1);
                buParam.addRule(RelativeLayout.BELOW,hongdenglong.getId());
                blueLine.setLayoutParams(buParam);
                c1.addView(blueLine);

                View jiange = new View(MyCollectActivity.this);
                jiange.setId(View.generateViewId());
                jiange.setBackgroundResource(R.color.background);
                RelativeLayout.LayoutParams jiangeParam=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,20);
                jiangeParam.addRule(RelativeLayout.BELOW,blueLine.getId());
                jiange.setLayoutParams(jiangeParam);
                c1.addView(jiange);

                c1.addView(blueLine1);
                return c1;
            }
        };
collect.setAdapter(collectAdapter);
    }

//    页面数据
    public List<MyCollect> collects(){
        Date date1 = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date1 = simpleDateFormat.parse("2015-04-26");
        }catch (Exception e){
            e.printStackTrace();
        }

        DateTime dt = new DateTime();
        int month = dt.getMonthOfYear();  // where January is 1 and December is 12
        int year = dt.getYear();
        int day = dt.getDayOfWeek();
//        year+"-"+month+"-"+day

        List<MyCollect> myCollects = new ArrayList<>();

        MyCollect myCollect1 = new MyCollect(R.drawable.t00, "乌鲁木齐5日游", "自由行", 3000, date1);
        MyCollect myCollect2 = new MyCollect(R.drawable.t01, "怪石谷7日游", "拼团游", 2999, date1);
        MyCollect myCollect3 = new MyCollect(R.drawable.t02, "交河故城3日游", "参团游", 2500, date1);

        myCollects.add(myCollect1);
        myCollects.add(myCollect2);
        myCollects.add(myCollect3);

        return myCollects;
    }
}
