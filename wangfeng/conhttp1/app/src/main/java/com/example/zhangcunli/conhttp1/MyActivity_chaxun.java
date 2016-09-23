package com.example.zhangcunli.conhttp1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyActivity_chaxun extends AppCompatActivity {


    private ListView listView;
    private final MyActivity_chaxun context = MyActivity_chaxun.this;
    List<Book> books;
    String url = "http://192.168.155.1/";
    private EditText editText;
    private ImageButton button;
    String bookname;
    private Button but_pkq;
    private ImageView imgv;
    private Button but_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_chaxun);

        editText=(EditText) findViewById(R.id.edit);
        button=(ImageButton) findViewById(R.id.butimg);
        bookname=editText.getText().toString().trim().replace(" ","");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookname=editText.getText().toString().trim().replace(" ","");

                kuanjian_lianjie();

            }
        });
        imgv=(ImageView) findViewById(R.id.imgv);
        but_back=(Button) findViewById(R.id.but_back);
        but_pkq=(Button) findViewById(R.id.but_pkq);
        but_pkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beijintu();
            }
        });
    }

    /**
     * 使用 Picasso 添加背景图
     */
    private  void beijintu(){
        Picasso.with(context).load(R.drawable.ic_launcher).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                //添加背景图片
                imgv.setBackground(new BitmapDrawable(getResources(),bitmap));
                //给图片添加背景图片
                but_back.setBackground(new BitmapDrawable(getResources(),bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.e("MyActivity_chaxun","-------加载失败-----------");

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Log.e("MyActivity_chaxun","-------准备加载-----------");
            }
        });
    }


    private void kuanjian_lianjie() {
        listView = (ListView) findViewById(R.id.listview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.155.1/")//指定基础资源定位器
                .addConverterFactory(GsonConverterFactory.create())//创建一个转换工场，将传入内容转换为Gson格式
                .build();//
        MyServerInterface serverInterface = retrofit.create(MyServerInterface.class);
        //Call 是个发送请求和返回响应
        Call<List<Book>> call = serverInterface.bookDetais_cx(bookname);//
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                int statusCode = response.code();//错误信息码
                Log.e("MainActivity", "--------------statusCode-----" + statusCode);
                books = response.body();//通过调用response.body() 获取数据

                listView.setAdapter(adp());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                t.printStackTrace();

                Log.e("MainActivity", "--------------出错了-----" + t.toString());
            }
        });

    }

    public BaseAdapter adp() {
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
                if(position==0){

                }
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                RelativeLayout rl = new RelativeLayout(context);

                ImageView imgcx = new ImageView(context);
                imgcx.setId(View.generateViewId());
                RelativeLayout.LayoutParams imgcxParams = new RelativeLayout.LayoutParams(200, 200);
                imgcx.setScaleType(ImageView.ScaleType.FIT_XY);
                String strurl = url + books.get(position).getBookface();
                Picasso.with(context).load(strurl).into(imgcx);
                imgcx.setPadding(10, 10, 10, 10);
                imgcx.setLayoutParams(imgcxParams);
                rl.addView(imgcx);

                TextView text1 = new TextView(context);
                text1.setId(View.generateViewId());

                text1.setText(String.valueOf(books.get(position).getBookId()));
                text1.setTextSize(25);
                text1.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams text1Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                text1Params.addRule(RelativeLayout.RIGHT_OF, imgcx.getId());
                text1.setLayoutParams(text1Params);
                rl.addView(text1);

                TextView text2 = new TextView(context);
                text2.setId(View.generateViewId());
                text2.setText(books.get(position).getName());
                text2.setTextSize(25);
                text2.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams text2Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                text2Params.addRule(RelativeLayout.RIGHT_OF, imgcx.getId());
                text2Params.addRule(RelativeLayout.BELOW, text1.getId());
                text2.setLayoutParams(text2Params);
                rl.addView(text2);

                return rl;
            }
        };
        return baseAdapter;
    }

}
