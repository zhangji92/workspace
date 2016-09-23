package com.example.zhangcunli.conhttp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView imageView;
    private EditText editText;
    private ListView listView;
    List<Book> books;
    String url = "http://192.168.155.1/";
    private final MainActivity context = MainActivity.this;
    private AutoCompleteTextView autoComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kuanjian_lianjie();
//        kuanjian2();
//        tupian();

        autoComplete=(AutoCompleteTextView) findViewById(R.id.auto);
        autoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyActivity_chaxun.class);
                startActivity(intent);
            }
        });




    }

//    private void tupian() {
//
//        editText = (EditText) findViewById(R.id.edit);
//        button1 = (Button) findViewById(R.id.btn1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String imgurl = editText.getText().toString().trim().replace(" ", "");
//                String url = "http://192.168.155.1/img/" + imgurl;
//                imageView = (ImageView) findViewById(R.id.img);
//                Picasso.with(MainActivity.this).load(url).into(imageView);
//                //通过 Picasso.with(上下文）加载一个http的网页图片地址  到 imageView这个控件上
//                // Picasso.with(MainActivity.this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
//            }
//        });
//
//
//    }

    private void kuanjian_lianjie() {
        listView = (ListView) findViewById(R.id.listda);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//指定基础资源定位器
                .addConverterFactory(GsonConverterFactory.create())//创建一个转换工场，将传入内容转换为Gson格式
                .build();//
        MyServerInterface serverInterface = retrofit.create(MyServerInterface.class);
        //Call 是个发送请求和返回响应
        Call<List<Book>> call = serverInterface.bookDetais_lj();//
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                int statusCode = response.code();//错误信息码
                Log.e("MainActivity", "--------------statusCode-----" + statusCode);
                books = response.body();//通过调用response.body() 获取数据

                listView.setAdapter(adpt());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                t.printStackTrace();

                Log.e("MainActivity", "--------------出错了-----" + t.toString());
            }
        });

    }


    public BaseAdapter adpt() {
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return books.size();
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

                RelativeLayout rl = new RelativeLayout(context);

                ImageView img = new ImageView(context);
                img.setId(View.generateViewId());
                RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(200, 200);
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                String strurl = url + books.get(position).getBookface();
                Picasso.with(context).load(strurl).into(img);
                img.setPadding(10, 10, 10, 10);
                img.setLayoutParams(imgParams);
                rl.addView(img);

                TextView te1 = new TextView(context);
                te1.setId(View.generateViewId());

                te1.setText(String.valueOf(books.get(position).getBookId()));
                te1.setTextSize(25);
                te1.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams te1Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                te1Params.addRule(RelativeLayout.RIGHT_OF, img.getId());
                te1.setLayoutParams(te1Params);
                rl.addView(te1);

                TextView te2 = new TextView(context);
                te2.setId(View.generateViewId());
                te2.setText(books.get(position).getName());
                te2.setTextSize(25);
                te2.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams te2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                te2Params.addRule(RelativeLayout.RIGHT_OF, img.getId());
                te2Params.addRule(RelativeLayout.BELOW, te1.getId());
                te2.setLayoutParams(te2Params);
                rl.addView(te2);

                return rl;
            }
        };
        return baseAdapter;
    }


//    private void kuanjian2() {
//
//
//        textView = (TextView) findViewById(R.id.txt);
//        button3 = (Button) findViewById(R.id.btn3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("http://192.168.155.1/")//指定基础资源定位器
//                        .addConverterFactory(GsonConverterFactory.create())//创建一个转换工场，将传入内容转换为Gson格式
//                        .build();//
//                MyServerInterface serverInterface = retrofit.create(MyServerInterface.class);
//                String bookname = "kuanjia2***2鸡哥666";
//                //Call 是个发送请求和返回响应  给这个接口传递一个参数
//                Call<List<Book>> call = serverInterface.bookDetais(bookname);//
//                call.enqueue(new Callback<List<Book>>() {
//                    @Override
//                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
//                        int statusCode = response.code();//错误信息码
//                        Log.e("MainActivity", "--------------statusCode-----" + statusCode);
//                        books = response.body();//通过调用response.body() 获取数据
//
//                        String bk = "";
//                        for (int i = 0; i < books.size(); i++) {
//                            Log.e("MainActivity", "--------------book-----" + books.get(i).getBookId());
//                            bk += books.get(i).getBookId() + books.get(i).getName() + "___" + books.get(i).getBookface();
//                        }
//                        textView.setText(bk);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Book>> call, Throwable t) {
//                        t.printStackTrace();
//
//                        Log.e("MainActivity", "--------------toString-----" + t.toString());
//                    }
//                });
//
//            }
//        });
//
//    }


}
