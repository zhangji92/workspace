package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mode.MyCollect;

public class MyActivity_laoshi extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_laoshi);

        toolbar = (Toolbar) findViewById(R.id.myTooblar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.jian_tou);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity_laoshi.this, MyActivity_02.class);
                startActivity(intent);
            }
        });

        //收藏内容列表
        ReflashListview collect = (ReflashListview) findViewById(R.id.collectList);
        collect.setBackgroundResource(R.color.myCollect);
        //创建 适配器
        BaseAdapter baseAdapter = new BaseAdapter() {
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

                RelativeLayout cl = new RelativeLayout(MyActivity_laoshi.this);//最外围布局
                cl.setBackgroundResource(R.color.textcolor);


                /**
                 *  水平线
                 */

                View shuiping = new View(MyActivity_laoshi.this);
                shuiping.setId(View.generateViewId());//自动生成id 避免重复
                shuiping.setBackgroundResource(R.color.toolbarBackground);//设置水平线
                //给水平线进行布局  设置宽高
                RelativeLayout.LayoutParams shuipingParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1);
                //设置属性
                shuiping.setLayoutParams(shuipingParams);
                cl.addView(shuiping);

                /**
                 * 图片
                 */
                ImageView tupian = new ImageView(MyActivity_laoshi.this);
                tupian.setId(View.generateViewId());//自动生成id 避免重复
                //取 collects() 集合中 指定下标的图片
                tupian.setImageResource(collects().get(position).getImage());
                //设置图片的内边距
                tupian.setPadding(12, 12, 12, 12);

                //创建一个布局属性，设置 宽高
                RelativeLayout.LayoutParams tupianParams = new RelativeLayout.LayoutParams(200, 150);
                //设置图片属性
                tupian.setLayoutParams(tupianParams);
                //将图片view 添加到  RelativeLayout 布局中
                cl.addView(tupian);

                /**
                 * 标题1
                 */
                TextView tv1 = new TextView(MyActivity_laoshi.this);
                tv1.setId(View.generateViewId());//自动生成id 避免重复
                tv1.setText(collects().get(position).getTitle());
                tv1.setTextColor(ContextCompat.getColor(tv1.getContext(), R.color.butTextColor));
                RelativeLayout.LayoutParams tv1Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                tv1Params.addRule(RelativeLayout.RIGHT_OF, tupian.getId());
                tv1Params.setMargins(5, 10, 0, 0);
                tv1.setLayoutParams(tv1Params);
                cl.addView(tv1);

                /**
                 * 旅游方式
                 */
                TextView tv2 = new TextView(MyActivity_laoshi.this);
                tv2.setId(View.generateViewId());
                tv2.setText(collects().get(position).getWhatWay());
                //设置背景
                tv2.setBackgroundResource(R.drawable.ziyuan);
                tv2.setTextColor(ContextCompat.getColor(tv2.getContext(), R.color.textcolor));
                //设置属性布局 宽 高
                RelativeLayout.LayoutParams tv2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                //tv2位于 tv1 的下方
                tv2Params.addRule(RelativeLayout.BELOW, tv1.getId());
                tv2Params.addRule(RelativeLayout.RIGHT_OF, tupian.getId());
                tv2.setLayoutParams(tv2Params);
                cl.addView(tv2);


                /**
                 * 费用
                 */
                TextView tv3 = new TextView(MyActivity_laoshi.this);
                tv3.setId(View.generateViewId());
                DecimalFormat nf = new DecimalFormat("###.00");
                String textStr = nf.format(collects().get(position).getPrice());
                tv3.setText("￥" + textStr + "起");
                tv3.setTextColor(ContextCompat.getColor(tv3.getContext(), R.color.red));
                RelativeLayout.LayoutParams tv3Parmams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                tv3Parmams.addRule(RelativeLayout.BELOW, tv2.getId());
                tv3Parmams.addRule(RelativeLayout.RIGHT_OF, tupian.getId());
                tv3.setLayoutParams(tv3Parmams);
                cl.addView(tv3);

                /**
                 * 出发日期
                 */
                TextView tv4 = new TextView(MyActivity_laoshi.this);
                tv4.setId(View.generateViewId());
                tv4.setPadding(0, 0, 20, 0);
                String datestr = "";
                SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                datestr = simple.format(collects().get(position).getGoDate());


                tv4.setText(datestr + "出发");
                tv4.setTextColor(ContextCompat.getColor(tv4.getContext(), R.color.tit4Color));
                RelativeLayout.LayoutParams tv4Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                tv4Params.addRule(RelativeLayout.BELOW, tv3.getId());
                tv4Params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                tv4.setLayoutParams(tv4Params);
                cl.addView(tv4);

                /**
                 * 下水平线
                 */
                View xiashuiping = new View(MyActivity_laoshi.this);
                xiashuiping.setId(View.generateViewId());
                xiashuiping.setBackgroundResource(R.color.toolbarBackground);
                RelativeLayout.LayoutParams xianshuipingParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1);
                xianshuipingParams.addRule(RelativeLayout.BELOW, tupian.getId());
                xiashuiping.setLayoutParams(xianshuipingParams);
                cl.addView(xiashuiping);


                /**
                 * 中间间隔
                 */
                TextView jiange = new TextView(MyActivity_laoshi.this);
                jiange.setId(View.generateViewId());
                jiange.setBackgroundResource(R.color.background);
                RelativeLayout.LayoutParams jiangeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 15);
                jiangeParams.addRule(RelativeLayout.BELOW, xiashuiping.getId());
                jiange.setLayoutParams(jiangeParams);
                cl.addView(jiange);

                return cl;
            }
        };
        collect.setAdapter(baseAdapter);

    }

    /**
     * 页面数据
     *
     * @return
     */
    public List<MyCollect> collects() {


        Date data1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            data1 = simpleDateFormat.parse("2015-04-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<MyCollect> myCollects = new ArrayList<>();

        MyCollect myCollect1 = new MyCollect(R.drawable.sou1, "乌鲁木齐5日游", "自由行", 3000, data1);
        MyCollect myCollect2 = new MyCollect(R.drawable.sou2, "呼和浩特7日游", "骑马行", 4000, data1);
        MyCollect myCollect3 = new MyCollect(R.drawable.sou3, "大草原4日游", "自由行", 3000, data1);
        MyCollect myCollect4 = new MyCollect(R.drawable.sou3, "草原4日游", "自由行", 3000, data1);
        MyCollect myCollect5 = new MyCollect(R.drawable.sou3, "原4日游大草原4日游", "自由行", 3000, data1);
        MyCollect myCollect6 = new MyCollect(R.drawable.sou3, "乌鲁木齐大草原4日游", "自由行", 3000, data1);

        myCollects.add(myCollect1);
        myCollects.add(myCollect2);
        myCollects.add(myCollect3);
        myCollects.add(myCollect4);
        myCollects.add(myCollect5);
        myCollects.add(myCollect6);


        return myCollects;
    }


}
