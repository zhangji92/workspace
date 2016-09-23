package com.gaoshen.wangfeng.fragmentmode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.fragment_1.Fragment_one;
import com.gaoshen.wangfeng.fragmentmode.fragment_2.Fragment_too;
import com.gaoshen.wangfeng.fragmentmode.fragment_3.Fragment_three;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Fragment_four;

public class MyFragmentMode extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout frameLayout;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private ImageView image1,image2,image3,image4;
    private TextView textView1,textView2,textView3,textView4;
    private Fragment_one f_one=new Fragment_one();
    private Fragment_too f_too;
    private Fragment_three f_three;
    private Fragment_four f_four;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment_mode);

        frameLayout= (FrameLayout) findViewById(R.id.framMode);


        image1= (ImageView) findViewById(R.id.image1);
        image2=  (ImageView)findViewById(R.id.image2);
        image3= (ImageView)findViewById(R.id.image3);
        image4= (ImageView) findViewById(R.id.image4);

        textView1= (TextView) findViewById(R.id.tex1);
        textView2= (TextView) findViewById(R.id.tex2);
        textView3= (TextView) findViewById(R.id.tex3);
        textView4= (TextView) findViewById(R.id.tex4);


        linearLayout1= (LinearLayout) findViewById(R.id.l1);
        linearLayout2= (LinearLayout) findViewById(R.id.l2);
        linearLayout3= (LinearLayout) findViewById(R.id.l3);
        linearLayout4= (LinearLayout) findViewById(R.id.l4);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);



        init();



    }


    public void init(){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.framMode,f_one);
        ft.commit();

        image1.setImageResource(R.drawable.sy1);
        textView1.setTextColor(ContextCompat.getColor(this,R.color.hong));
    }

    @Override
    public void onClick(View view) {

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        fragmentShow(ft);//所有Fragment 都隐藏
        imgShow(); //所有图片都为默认图片
        textColor();//所有字体都为默认颜色字体
        int id=view.getId();

        if(id== linearLayout1.getId()){

            image1.setImageResource(R.drawable.sy1);
            textView1.setTextColor(ContextCompat.getColor(this,R.color.hong));

            if(f_one==null){
               f_one=new Fragment_one();
                ft.add(R.id.framMode,f_one,"one");


            }else{

                ft.show(f_one);

            }

        }else if(id== linearLayout2.getId()){

            image2.setImageResource(R.drawable.tong1);
            textView2.setTextColor(ContextCompat.getColor(this,R.color.hong));

            if(f_too==null){
                f_too=new Fragment_too();
                ft.add(R.id.framMode,f_too,"too");


            }else{
                ft.show(f_too);
            }

        }else if(id== linearLayout3.getId()){

            image3.setImageResource(R.drawable.you1);
            textView3.setTextColor(ContextCompat.getColor(this,R.color.hong));

            if(f_three==null){
                f_three=new Fragment_three();
                ft.add(R.id.framMode,f_three,"three");


            }else{
                ft.show(f_three);
            }

        }else if(id== linearLayout4.getId()){

            image4.setImageResource(R.drawable.wo1);
            textView4.setTextColor(ContextCompat.getColor(this,R.color.hong));

            if(f_four==null){
                f_four=new Fragment_four();
                ft.add(R.id.framMode,f_four,"four");


            }else{
                ft.show(f_four);
            }
        }
        ft.commit();
    }

    /**
     * 所有图片都为默认图片
     */
    public void imgShow(){
        image1.setImageResource(R.drawable.sy0);
        image2.setImageResource(R.drawable.tong0);
        image3.setImageResource(R.drawable.you0);
        image4.setImageResource(R.drawable.wo0);
    }

    /**所有Fragment 都隐藏
     *
     * @param ft
     */
    public void fragmentShow(FragmentTransaction ft){
       if(f_one!=null){
           ft.hide(f_one);
       }
       if(f_too!=null){
           ft.hide(f_too);
       }
       if(f_three!=null){
           ft.hide(f_three);
        }
       if(f_four!=null){
           ft.hide(f_four);
       }
    }

    /**
     * 所有字体都为默认颜色字体
     */
    public void textColor(){
        textView1.setTextColor(ContextCompat.getColor(this,R.color.shui));
        textView2.setTextColor(ContextCompat.getColor(this,R.color.shui));
        textView3.setTextColor(ContextCompat.getColor(this,R.color.shui));
        textView4.setTextColor(ContextCompat.getColor(this,R.color.shui));
    }


}
