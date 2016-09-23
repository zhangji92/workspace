package com.gaoshen.wangfeng.wangfeng07070845;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyActivity extends AppCompatActivity {


    List<Book> books;
    String str;
    private EditText editText;
    private ImageView imageView;
    private ListView listView;
    String url = "http://192.168.155.1/";
    private final MyActivity context =  MyActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);




        listView=(ListView) findViewById(R.id.listview_1);
        editText=(EditText) findViewById(R.id.edit_text);
        imageView=(ImageView) findViewById(R.id.img_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str= editText.getText().toString().trim().replace(" ","");

                sousuo();
            }
        });
    }


    public void sousuo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.155.1/")//指定基础资源定位器
                .addConverterFactory(GsonConverterFactory.create())//创建一个转换工场，将传入内容转换为Gson格式
                .build();//
        MyServerInterface se = retrofit.create(MyServerInterface.class);
        //Call 是个发送请求和返回响应
        Call<List<Book>> call = se.bookDetais_cx(str);
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                int statusCode = response.code();//错误信息码
                Log.e("MYActivity", "--------------statusCode-----" + statusCode);
                books = response.body();//通过调用response.body() 获取数据

//                for (int i=0;i<books.size();i++){
//                    Log.e("MyA",""+books[i]);
//                }

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
                String strurl = url + books.get(position).getImg();
                Picasso.with(context).load(strurl).into(img);
                img.setPadding(10, 10, 10, 10);
                img.setLayoutParams(imgParams);
                rl.addView(img);

                TextView te2 = new TextView(context);
                te2.setId(View.generateViewId());
                String stri=String.valueOf(books.get(position).getPrice());
                te2.setText("￥"+stri);
                te2.setTextSize(25);
                te2.setTextColor(ContextCompat.getColor(MyActivity.this,R.color.hong));
                te2.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams te2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                te2Params.addRule(RelativeLayout.RIGHT_OF, img.getId());
                te2Params.setMargins(0,15,0,0);
                te2.setLayoutParams(te2Params);
                rl.addView(te2);

                TextView te1 = new TextView(context);
                te1.setId(View.generateViewId());
                te1.setText(String.valueOf(books.get(position).getTitle()));
                te1.setTextSize(25);
                te1.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams te1Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                te1Params.addRule(RelativeLayout.RIGHT_OF, img.getId());
                te1Params.addRule(RelativeLayout.BELOW, te2.getId());
                te1.setLayoutParams(te1Params);
                rl.addView(te1);



                return rl;
            }
        };
        return baseAdapter;
    }

}
