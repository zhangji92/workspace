package com.gaoshen.wangfeng.fragmentmode.fragment_4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.ResultCodeBean;
import com.gaoshen.wangfeng.fragmentmode.util.HttpTools;

public class User extends AppCompatActivity implements View.OnClickListener{

    private TextView tit;
    private ImageView userimg;//用户头像
    private TextView userphone;//用户名（手机号）
    private EditText username;//昵称
    private EditText userage;//用户年龄
    private EditText useraddress;//地址
    private Button save;//保存按钮
    private Button esc;//退出账号按钮
    private RadioButton nan;
    private RadioButton nv;
    private ResultCodeBean res;
    private String token;
    private String imgUrl;
    String uname;
    String uage;
    String sex="";
    String uadd;

    private Handler uHandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 666:
                   String str = (String) msg.obj;
                    Log.e("=====USER=====",str );
                    break;
//                case 912:
//                    res= (ResultCodeBean) msg.obj;
//                    token=res.getToken();
//                    Log.e("--*****---token ",token );
//                    imgUrl=res.getImgUrl();
//                    Log.e("--*****---imgUrl ",imgUrl );

//                    res = (ResultCodeBean) msg.obj;
//                    FinalDb db = FinalDb.create(User.this);
//                    res = db.findById(res.getId(), ResultCodeBean.class);
//                    delzc.setText(res.getNickname());
//                    Log.e("=====USER=====",token );
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tit= (TextView) findViewById(R.id.tit_text);
        tit.setText("个人信息");

        userimg= (ImageView) findViewById(R.id.userimg);
        userphone= (TextView) findViewById(R.id.userphone);
        username= (EditText) findViewById(R.id.username);
        userage= (EditText) findViewById(R.id.userage);
        useraddress= (EditText) findViewById(R.id.useraddress);
        nan= (RadioButton) findViewById(R.id.boy);
        nv= (RadioButton) findViewById(R.id.gril);
        save= (Button) findViewById(R.id.save);
        esc= (Button) findViewById(R.id.esc);

        save.setOnClickListener(this);
        esc.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        MyApplication my= (MyApplication) getApplication();
        token=my.getCodeBeen().getToken();
        imgUrl=my.getCodeBeen().getImgUrl();
        uname=username.getText().toString();//昵称
        uage=userage.getText().toString();//年龄

        if(nan.isChecked()==true){
            String strSex=nan.getText().toString();
            if(strSex.equals("男")){
                sex="1";
            }
        }else if(nv.isChecked()==true){
            String strSex=nan.getText().toString();
            if(strSex.equals("女")){
                sex="2";
            }
            sex=nv.getText().toString();
        }
       uadd=useraddress.getText().toString();//地址



        switch (view.getId()){
            case R.id.save:
//                sevadata();
                HttpTools.getHttpTools().setUser(uHandle,token,uname,sex,uage,uadd,imgUrl);

                break;
            case R.id.esc:
                Intent in=new Intent();
                in.putExtra("str","登录/注册");
                setResult(11,in);
                finish();

                break;
        }
    }

    private void sevadata() {
        res.setAddress(uadd);
        res.setAge(uage);
        res.setGender(sex);
        res.setNickname(uname);
        res.setRy_token(token);
        res.setImgUrl(null);
    }
}
