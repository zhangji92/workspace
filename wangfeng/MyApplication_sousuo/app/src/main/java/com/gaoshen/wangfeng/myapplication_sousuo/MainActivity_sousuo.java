package com.gaoshen.wangfeng.myapplication_sousuo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mode.book;

public class MainActivity_sousuo extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    String str[]={"aaaa","bbbb","ccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_sousuo);
//        listView.setAdapter(adp());
        listView=(ListView) findViewById(R.id.list_sousuo);
        //设置listView 启用过滤器
        listView.setTextFilterEnabled(true);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity_sousuo.this,android.R.layout.simple_list_item_1,str));
        searchView=(SearchView) findViewById(R.id.sear);
        //设置searchView是否自动缩小为图标
        searchView.setIconifiedByDefault(false);
        //设置searchView显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置searchView内默认搜索按钮
        searchView.setQueryHint("请输入您要搜索的内容");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //用户输入字符是激发该方法
            @Override
            public boolean onQueryTextChange(String newText) {

                //newText不是长度为0的字符
                if(TextUtils.isEmpty(newText)){
                    //清除listView的过滤
                    listView.clearTextFilter();
                }else{
                    //使用用户输入的内容对listView进行过滤
                    listView.setFilterText(newText);
                }

                return true;
            }

            //用户单击搜索按钮是激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }


        });

    }

//    private BaseAdapter adp(){
//        BaseAdapter ba=new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return  books().size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                RelativeLayout re=new RelativeLayout(MainActivity_sousuo.this);
//
//                ImageView im=new ImageView(MainActivity_sousuo.this);
//                im.setId(View.generateViewId());
//                im.setImageResource(books().get(position).getImg());
//                re.addView(im);
//
//                TextView te1=new TextView(MainActivity_sousuo.this);
//                te1.setId(View.generateViewId());
//                te1.setText(books().get(position).getBookid());
//                te1.setTextSize(25);
//                re.addView(te1);
//
//                TextView te2=new TextView(MainActivity_sousuo.this);
//                te2.setId(View.generateViewId());
//                te2.setText(books().get(position).getName());
//                te2.setTextSize(25);
//                re.addView(te2);
//
//                return re;
//            }
//        };
//        return ba;
//    }
//
//    public List<book> books(){
//        List<book> list=new ArrayList<>();
//        book bk1=new book(100,"凡尔纳",R.drawable.xiaoyang);
//        book bk2=new book(100,"高尔基",R.drawable.xidapuben);
//        book bk3=new book(100,"驴熊",R.drawable.xidapuben);
//
//        list.add(bk1);list.add(bk2);list.add(bk3);
//        return list;
//    }
}
