package com.gaoshen.wangfeng.biying_lianxi;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mode.Biying;
import mode.By_HorizontalScroll;

public class MyActivity_01 extends AppCompatActivity {

    private Toolbar toolbarBy;
    private String url = "https://cn.bing.com/";
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_01);

        toolbarBy = (Toolbar) findViewById(R.id.toolbarby);
        setSupportActionBar(toolbarBy);
        toolbarBy.setLogo(R.drawable.dao1);
        listView = (ListView) findViewById(R.id.listview_biying);

        baseAdapter();


    }

    /**
     * 通过baseAdapter 向listView中添加组件
     */
    public void baseAdapter() {
        BaseAdapter baseAdapter_by = new BaseAdapter() {
            @Override
            public int getCount() {
                return biyings().size();
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

                RelativeLayout zuiwai = new RelativeLayout(MyActivity_01.this);//最外层布局

                TextView today = new TextView(MyActivity_01.this);
                today.setId(View.generateViewId());
                today.getPaint().setFakeBoldText(true);
                today.setTextSize(25);
                today.setTextColor(ContextCompat.getColor(today.getContext(), R.color.zuozi));
                RelativeLayout.LayoutParams todayParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                todayParams.setMargins(0, 20, 0, 0);
                today.setLayoutParams(todayParams);
                if (position == 0) {
                    today.setText("TODAY");
                } else {

//                String datestr = "";
//                SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
//                datestr = simple.format(biyings().get(position).getToday());
                    today.setText(biyings().get(position).getToday());

                }


                zuiwai.addView(today);


                RelativeLayout by = new RelativeLayout(MyActivity_01.this);
                by.setBackgroundResource(R.drawable.biankuan);
                RelativeLayout.LayoutParams byParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                byParams.addRule(RelativeLayout.BELOW, today.getId());
                byParams.addRule(RelativeLayout.ALIGN_LEFT, today.getId());
                byParams.setMargins(0, 10, 0, 0);
                by.setLayoutParams(byParams);
                by.setId(View.generateViewId());


                /**
                 * 图片
                 */
                ImageView citu = new ImageView(MyActivity_01.this);
                citu.setId(View.generateViewId());
                //设置图片
                citu.setImageResource(biyings().get(position).getImg());
                citu.setPadding(10, 10, 10, 0);
                citu.setLayoutParams(new RelativeLayout.LayoutParams(180, 160));
                citu.setScaleType(ImageView.ScaleType.FIT_XY);
                by.addView(citu);

                /**
                 * 单词
                 */
                TextView danci = new TextView(MyActivity_01.this);
                danci.setId(View.generateViewId());
                danci.setText(biyings().get(position).getDayword());
                danci.setTextSize(23);
                danci.setTextColor(ContextCompat.getColor(danci.getContext(), R.color.daocolor));
                RelativeLayout.LayoutParams danciParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                danciParams.addRule(RelativeLayout.RIGHT_OF, citu.getId());
                danci.setLayoutParams(danciParams);
                danci.setPadding(2, 8, 2, 2);
                by.addView(danci);

                /**
                 * 发音
                 */
                TextView fayin = new TextView(MyActivity_01.this);
                fayin.setId(View.generateViewId());
                fayin.setText(biyings().get(position).getPronounce());
                fayin.setTextSize(18);
                fayin.setTextColor(ContextCompat.getColor(fayin.getContext(), R.color.fayincolor));
                fayin.setPadding(2, 2, 2, 2);
                RelativeLayout.LayoutParams fayinParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                fayinParams.addRule(RelativeLayout.BELOW, danci.getId());
                fayinParams.addRule(RelativeLayout.RIGHT_OF, citu.getId());
                fayinParams.addRule(RelativeLayout.ALIGN_LEFT, danci.getId());
                fayin.setLayoutParams(fayinParams);
                by.addView(fayin);

                /**
                 * 译文
                 */
                TextView yiwen = new TextView(MyActivity_01.this);
                yiwen.setId(View.generateViewId());
                yiwen.setText(biyings().get(position).getTranslation());
                yiwen.setTextSize(18);
                yiwen.setTextColor(ContextCompat.getColor(yiwen.getContext(), R.color.fayincolor));
                yiwen.setPadding(2, 2, 2, 2);
                RelativeLayout.LayoutParams yiwenParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                yiwenParams.addRule(RelativeLayout.BELOW, fayin.getId());
                yiwenParams.addRule(RelativeLayout.RIGHT_OF, citu.getId());
                yiwenParams.addRule(RelativeLayout.ALIGN_LEFT, danci.getId());
                by.addView(yiwen);
                yiwen.setLayoutParams(yiwenParams);

                /**
                 * 下划线
                 */
                View xian = new View(MyActivity_01.this);
                xian.setId(View.generateViewId());
                xian.setBackgroundResource(R.color.bordercolor);
                RelativeLayout.LayoutParams xianParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 2);
                xianParams.addRule(RelativeLayout.BELOW, citu.getId());
                xianParams.setMargins(0, 10, 0, 0);
                xianParams.addRule(RelativeLayout.ALIGN_LEFT, citu.getId());
                xian.setLayoutParams(xianParams);
                by.addView(xian);

                /**
                 * 每日一词
                 */
                TextView meir = new TextView(MyActivity_01.this);
                meir.setId(View.generateViewId());
                meir.setText(biyings().get(position).getMei_dayword());
                meir.setTextColor(ContextCompat.getColor(meir.getContext(), R.color.fayincolor));
                meir.setPadding(15, 10, 15, 10);
                meir.setTextSize(25);
                RelativeLayout.LayoutParams meirParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                meirParams.addRule(RelativeLayout.BELOW, xian.getId());
                meir.setLayoutParams(meirParams);
                by.addView(meir);

                /**
                 * 图片
                 */
                ImageView jia = new ImageView(MyActivity_01.this);
                jia.setId(View.generateViewId());
                jia.setImageResource(biyings().get(position).getJiatu());
                RelativeLayout.LayoutParams jiaParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                jiaParams.addRule(RelativeLayout.BELOW, xian.getId());
                jiaParams.addRule(RelativeLayout.RIGHT_OF, meir.getId());
                jia.setLayoutParams(jiaParams);
                jia.setPadding(145, 2, 0, 0);
                by.addView(jia);

                //添加第一个布局
                zuiwai.addView(by);

                HorizontalScrollView hs = new HorizontalScrollView(MyActivity_01.this);
                hs.setId(View.generateViewId());
                hs.setHorizontalScrollBarEnabled(false);
                hs.setBackgroundResource(R.drawable.biankuan);
                RelativeLayout.LayoutParams hsParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                hsParams.addRule(RelativeLayout.BELOW, by.getId());
                hsParams.setMargins(0, 20, 0, 0);
                hs.setLayoutParams(hsParams);


                //第二个布局



                if (position == 0) {
                    RelativeLayout by2 = new RelativeLayout(MyActivity_01.this);
                    by2.setId(View.generateViewId());
                    RelativeLayout.LayoutParams by2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    by2Params.setMargins(0, 20, 0, 10);
                    by2Params.addRule(RelativeLayout.BELOW, by.getId());
                    by2.setPadding(10, 10, 10, 10);
                    by2.setLayoutParams(by2Params);

                    // 图
                    ImageView img1 = new ImageView(MyActivity_01.this);
                    img1.setId(View.generateViewId());
                    img1.setImageResource(R.drawable.mei1);
                    RelativeLayout.LayoutParams img1Params = new RelativeLayout.LayoutParams(90, 120);
                    img1.setLayoutParams(img1Params);
                    by2.addView(img1);


                    ImageView img2 = new ImageView(MyActivity_01.this);
                    img2.setId(View.generateViewId());
                    img2.setImageResource(R.drawable.mei2);
                    RelativeLayout.LayoutParams img2Params = new RelativeLayout.LayoutParams(90, 120);
                    img2Params.setMargins(100, 0, 0, 0);
                    img2.setLayoutParams(img2Params);
                    by2.addView(img2);

                    ImageView img3 = new ImageView(MyActivity_01.this);
                    img3.setId(View.generateViewId());
                    img3.setImageResource(R.drawable.mei3);
                    img3.setPadding(10, 0, 0, 0);
                    img3.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img3Params = new RelativeLayout.LayoutParams(98, 120);
                    img3Params.addRule(RelativeLayout.RIGHT_OF, img2.getId());
                    img3.setLayoutParams(img3Params);
                    by2.addView(img3);

                    ImageView img4 = new ImageView(MyActivity_01.this);
                    img4.setId(View.generateViewId());
                    img4.setImageResource(R.drawable.mei4);
                    img4.setPadding(10, 0, 0, 0);
                    img4.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img4Params = new RelativeLayout.LayoutParams(98, 120);
                    img4Params.addRule(RelativeLayout.RIGHT_OF, img3.getId());
                    img4.setLayoutParams(img4Params);
                    by2.addView(img4);

                    ImageView img5 = new ImageView(MyActivity_01.this);
                    img5.setId(View.generateViewId());
                    img5.setImageResource(R.drawable.mei5);
                    img5.setPadding(10, 0, 0, 0);
                    img5.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img5Params = new RelativeLayout.LayoutParams(98, 120);
                    img5Params.addRule(RelativeLayout.RIGHT_OF, img4.getId());
                    img5.setLayoutParams(img5Params);
                    by2.addView(img5);

                    ImageView img6 = new ImageView(MyActivity_01.this);
                    img6.setId(View.generateViewId());
                    img6.setImageResource(R.drawable.mei6);
                    img6.setPadding(10, 0, 0, 0);
                    img6.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img6Params = new RelativeLayout.LayoutParams(98, 120);
                    img6Params.addRule(RelativeLayout.RIGHT_OF, img5.getId());
                    img6.setLayoutParams(img6Params);
                    by2.addView(img6);

                    ImageView img7 = new ImageView(MyActivity_01.this);
                    img7.setId(View.generateViewId());
                    img7.setImageResource(R.drawable.wo1);
                    img7.setPadding(10, 0, 0, 0);
                    img7.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img7Params = new RelativeLayout.LayoutParams(98, 120);
                    img7Params.addRule(RelativeLayout.RIGHT_OF, img6.getId());
                    img7.setLayoutParams(img6Params);
                    by2.addView(img7);

                    ImageView img8 = new ImageView(MyActivity_01.this);
                    img8.setId(View.generateViewId());
                    img8.setImageResource(R.drawable.wo2);
                    img8.setPadding(10, 0, 0, 0);
                    img8.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img8Params = new RelativeLayout.LayoutParams(98, 120);
                    img8Params.addRule(RelativeLayout.RIGHT_OF, img7.getId());
                    img8.setLayoutParams(img8Params);
                    by2.addView(img8);

                    ImageView img9 = new ImageView(MyActivity_01.this);
                    img9.setId(View.generateViewId());
                    img9.setImageResource(R.drawable.wo3);
                    img9.setPadding(10, 0, 0, 0);
                    img9.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams img9Params = new RelativeLayout.LayoutParams(98, 120);
                    img9Params.addRule(RelativeLayout.RIGHT_OF, img8.getId());
                    img9.setLayoutParams(img9Params);
                    by2.addView(img9);

                    //滚动条加载 第二个布局
                    hs.addView(by2);



                } else {

                    RelativeLayout by2 = new RelativeLayout(MyActivity_01.this);
                    by2.setId(View.generateViewId());
                    RelativeLayout.LayoutParams by2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,1);
//                    by2Params.setMargins(0, 20, 0, 10);
                    by2.setLayoutParams(by2Params);
                    hs.addView(by2);

                }
                //最外层布局 加载滚动布局
                zuiwai.addView(hs);




                RelativeLayout by3 = new RelativeLayout(MyActivity_01.this);
                by3.setId(View.generateViewId());
                by3.setPadding(15, 10, 10, 7);
                by3.setBackgroundResource(R.drawable.biankuan);
                RelativeLayout.LayoutParams by3Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if(position==0){
                    by3Params.setMargins(0, 20, 0, 0);
                }
                //第三个布局

                by3Params.addRule(RelativeLayout.BELOW, hs.getId());
                by3.setLayoutParams(by3Params);


                //图片
                ImageView yuetu = new ImageView(MyActivity_01.this);
                yuetu.setId(View.generateViewId());
                yuetu.setImageResource(biyings2().get(position).getYuetu());
                RelativeLayout.LayoutParams yuetuParams = new RelativeLayout.LayoutParams(110, 70);
//                yuetu.setScaleType(ImageView.ScaleType.FIT_XY);
                yuetu.setLayoutParams(yuetuParams);
                by3.addView(yuetu);

                //题目
                TextView tittext = new TextView(MyActivity_01.this);
                tittext.setId(View.generateViewId());
                tittext.setTextSize(22);
                //设置粗体
                tittext.getPaint().setFakeBoldText(true);
                tittext.setTextColor(ContextCompat.getColor(tittext.getContext(), R.color.zibacolor));
                tittext.setText(biyings2().get(position).getTitle());
                RelativeLayout.LayoutParams tittextParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                tittextParams.addRule(RelativeLayout.RIGHT_OF, yuetu.getId());
                tittextParams.setMargins(10, 0, 0, 0);
                tittext.setLayoutParams(tittextParams);
                by3.addView(tittext);

                //作者
                TextView zuoze = new TextView(MyActivity_01.this);
                zuoze.setId(View.generateViewId());
                zuoze.setTextColor(ContextCompat.getColor(tittext.getContext(), R.color.zuozi));
                zuoze.setText(biyings2().get(position).getZuoze());
                RelativeLayout.LayoutParams zuozeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                zuozeParams.addRule(RelativeLayout.RIGHT_OF, yuetu.getId());
                zuozeParams.addRule(RelativeLayout.BELOW, tittext.getId());
                zuozeParams.addRule(RelativeLayout.ALIGN_LEFT, tittext.getId());
                zuoze.setLayoutParams(zuozeParams);
                by3.addView(zuoze);

                //内容
                TextView text = new TextView(MyActivity_01.this);
                text.setId(View.generateViewId());
                text.setTextColor(ContextCompat.getColor(tittext.getContext(), R.color.daocolor));
                text.setText(biyings2().get(position).getText());
                RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                textParams.addRule(RelativeLayout.BELOW, yuetu.getId());
                textParams.setMargins(0, 15, 0, 0);
                text.setLayoutParams(textParams);
                by3.addView(text);


                /**
                 * 下划线
                 */
                View xian2 = new View(MyActivity_01.this);
                xian2.setId(View.generateViewId());
                xian2.setBackgroundResource(R.color.bordercolor);
                RelativeLayout.LayoutParams xian2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 2);
                xian2Params.addRule(RelativeLayout.BELOW, text.getId());
                xian2Params.setMargins(0, 10, 0, 0);
                xian2Params.addRule(RelativeLayout.ALIGN_LEFT, yuetu.getId());
                xian2.setLayoutParams(xian2Params);
                by3.addView(xian2);

                /**
                 * 推荐阅读
                 */
                TextView meirj = new TextView(MyActivity_01.this);
                meirj.setId(View.generateViewId());
                meirj.setText(biyings2().get(position).getMeiyu());
                meirj.setTextColor(ContextCompat.getColor(meir.getContext(), R.color.fayincolor));
                meirj.setPadding(10, 10, 0, 0);
                meirj.setTextSize(25);
                RelativeLayout.LayoutParams meirjParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                meirjParams.addRule(RelativeLayout.BELOW, xian2.getId());
                meirj.setLayoutParams(meirjParams);
                by3.addView(meirj);

                zuiwai.addView(by3);


                RelativeLayout by4 = new RelativeLayout(MyActivity_01.this);
                by4.setId(View.generateViewId());
                if (position == 0) {
                    by4.setPadding(10, 10, 10, 10);
                    by4.setBackgroundResource(R.drawable.biankuan);
                    RelativeLayout.LayoutParams by4Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    by4Params.addRule(RelativeLayout.BELOW, by3.getId());
                    by4Params.setMargins(0, 20, 0, 0);
                    by4.setLayoutParams(by4Params);


                    TextView textby4 = new TextView(MyActivity_01.this);
                    textby4.setId(View.generateViewId());
                    textby4.setText("今天还没有添加生词");
                    textby4.setTextSize(23);
                    textby4.setPadding(5, 5, 0, 3);
                    RelativeLayout.LayoutParams textby4Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    textby4.setLayoutParams(textby4Params);
                    by4.addView(textby4);


                    TextView textby5 = new TextView(MyActivity_01.this);
                    textby5.setId(View.generateViewId());
                    textby5.setText("click to open");
                    textby5.setTextSize(25);
                    textby5.setPadding(5, 0, 0, 3);
                    //设置粗体
                    textby5.getPaint().setFakeBoldText(true);
                    textby5.setTextColor(ContextCompat.getColor(textby5.getContext(), R.color.zuozi));
                    RelativeLayout.LayoutParams textby5Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    textby5Params.addRule(RelativeLayout.BELOW, textby4.getId());
                    textby5.setLayoutParams(textby5Params);
                    by4.addView(textby5);

                    /**
                     * 下划线
                     */
                    View xian3 = new View(MyActivity_01.this);
                    xian3.setId(View.generateViewId());
                    xian3.setBackgroundResource(R.color.bordercolor);
                    RelativeLayout.LayoutParams xian3Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 2);
                    xian3Params.addRule(RelativeLayout.BELOW, textby5.getId());
                    xian3Params.setMargins(0, 10, 0, 0);
                    xian3.setLayoutParams(xian3Params);
                    by4.addView(xian3);

                    TextView textby6 = new TextView(MyActivity_01.this);
                    textby6.setId(View.generateViewId());
                    textby6.setText("生词活动本");
                    textby6.setTextSize(23);
                    textby6.setTextColor(ContextCompat.getColor(textby6.getContext(), R.color.fayincolor));
                    textby6.setPadding(10, 10, 0, 5);
                    RelativeLayout.LayoutParams textby6Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    textby6Params.addRule(RelativeLayout.BELOW, xian3.getId());
                    textby6.setLayoutParams(textby6Params);
                    by4.addView(textby6);
                } else {
                    by4.setBackgroundResource(R.drawable.biankuan);
                    RelativeLayout.LayoutParams by4Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 10);
                    by4Params.addRule(RelativeLayout.BELOW, by3.getId());
//                    by4Params.setMargins(0, 10, 0, 0);
                    by4.setLayoutParams(by4Params);
                }


                zuiwai.addView(by4);


                RelativeLayout by5 = new RelativeLayout(MyActivity_01.this);
                by5.setId(View.generateViewId());
                by5.setBackgroundResource(R.drawable.biankuan);
                RelativeLayout.LayoutParams by5Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                by5Params.setMargins(0, 20, 0, 0);
                by5Params.addRule(RelativeLayout.BELOW, by4.getId());
                by5.setPadding(10, 10, 10, 10);
                by5.setLayoutParams(by5Params);


                TextView yingyu = new TextView(MyActivity_01.this);
                yingyu.setId(View.generateViewId());
                yingyu.setText(biyings5().get(position).getYingyujz());
                yingyu.setTextSize(23);
                yingyu.setTextColor(ContextCompat.getColor(yingyu.getContext(), R.color.zibacolor));
                RelativeLayout.LayoutParams yingyuParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                yingyu.setLayoutParams(yingyuParams);
                by5.addView(yingyu);

                TextView fanzi = new TextView(MyActivity_01.this);
                fanzi.setId(View.generateViewId());
                fanzi.setText(biyings5().get(position).getZhongwen());
                fanzi.setTextSize(23);
                fanzi.setTextColor(ContextCompat.getColor(fanzi.getContext(), R.color.fayincolor));
                RelativeLayout.LayoutParams fanziParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                fanziParams.addRule(RelativeLayout.BELOW, yingyu.getId());
                fanzi.setLayoutParams(fanziParams);
                by5.addView(fanzi);


                /**
                 * 下划线
                 */
                View xian4 = new View(MyActivity_01.this);
                xian4.setId(View.generateViewId());
                xian4.setBackgroundResource(R.color.bordercolor);
                RelativeLayout.LayoutParams xian4Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 2);
                xian4Params.addRule(RelativeLayout.BELOW, fanzi.getId());
                xian4Params.setMargins(0, 10, 0, 0);
                xian4.setLayoutParams(xian4Params);
                by5.addView(xian4);

                TextView merryij = new TextView(MyActivity_01.this);
                merryij.setId(View.generateViewId());
                merryij.setText(biyings5().get(position).getMeiryij());
                merryij.setTextSize(23);
                merryij.setPadding(5, 5, 5, 5);
                merryij.setTextColor(ContextCompat.getColor(merryij.getContext(), R.color.fayincolor));
                RelativeLayout.LayoutParams merryijParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                merryijParams.addRule(RelativeLayout.BELOW, xian4.getId());
                merryij.setLayoutParams(merryijParams);
                by5.addView(merryij);

                zuiwai.addView(by5);


                return zuiwai;
            }
        };
        listView.setAdapter(baseAdapter_by);
    }


    /**
     * 添加子菜单
     *
     * @param menu
     * @return true 显示子菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载menu 中的 menu文件
        getMenuInflater().inflate(R.menu.biying_menu, menu);
        return true;
    }

    /**
     * 回调方法监听点击事件
     *
     * @param item 子菜单中的元素
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.biy1) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 通过构造方法 向ListView 中添加数据
     *
     * @return list
     */
    public List<Biying> biyings() {
        Date strDate = new Date();
        String date = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }


        final List<Biying> list_by = new ArrayList<>();
        Biying biying = new Biying(date, R.drawable.dancitu1, "avocado", "US:[aeve'kadou]", "鳄梨", "每日一词", R.drawable.text_tu1, R.drawable.yuetu1, "This Backs", "Mental Floss", "vfavdarvfdabbgngbanhjmukuikuilyjthsgfvczbfbfbgtsrtaatarjatrhtrbg");
        Biying biying2 = new Biying(date, R.drawable.dancitu1, "avocado", "US:[aeve'kadou]", "鳄梨", "每日一词", R.drawable.text_tu1, R.drawable.yuetu1, "This Backs", "Mental Floss", "vfavdarvfdabbgngbanhjmukuikuilyjthsgfvczbfbfbgtsrtaatarjatrhtrbg");


        list_by.add(biying);
        list_by.add(biying2);


        return list_by;
    }

    public List<Biying> biyings2() {
        final List<Biying> list_by = new ArrayList<>();
        Biying biying2 = new Biying(R.drawable.yuetu1, "This Backs", "Mental Floss", "vfavdarvfdabbgngbanhjmukuikuilyjthsgfvczbfbfbgtsrtaatarjatrhtrbg88888" +
                "888888888888888888888888888888888888888888888888", "推荐阅读");
        Biying biying3 = new Biying(R.drawable.yuetu1, "This Backs", "Mental Floss", "vfavdarvfdabbgngbanhjmukuikuilyjthsgfvczbfbfbgtsrtaatarjatrhtrbg88888" +
                "888888888888888888888888888888888888888888888888", "推荐阅读");


        list_by.add(biying2);
        list_by.add(biying3);


        return list_by;
    }

    public List<Biying> biyings5() {
        final List<Biying> list_by = new ArrayList<>();

        Biying biying5 = new Biying("Don't worry if you have had a bad day.We each have a reset button. it's called tomorrow",
                "如果你今天过得很糟，别担心，我们都有一个重置按钮叫做“明天”。", "每日一句");

        Biying biying6 = new Biying("Don't worry if you have had a bad day.We each have a reset button. it's called tomorrow",
                "如果你今天过得很糟，别担心，我们都有一个重置按钮叫做“明天”。", "每日一句");

        list_by.add(biying5);
        list_by.add(biying6);


        return list_by;
    }


}
