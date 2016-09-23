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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.DengluMode;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.SiMode;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;
import com.gaoshen.wangfeng.fragmentmode.util.HttpTools;
import com.google.gson.Gson;

import net.tsz.afinal.FinalDb;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private RadioButton radio;
    private EditText editZH;
    private EditText editMI;
    private Button button;
    private DengluMode dm;
    private String str;
    private SiMode sim;
    private String username;
    private String mima;

    private Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case BaseUrl.DENG:
                   String str= (String) msg.obj;
                    Gson gson=new Gson();
                    if(str.contains("错误")){
                        SiMode si=gson.fromJson(str,SiMode.class);
                        shibai(si);

                    }else if(str.contains("成功")){
                        DengluMode deng=gson.fromJson(str,DengluMode.class);
                        Log.e("handleMessage: ",deng.getMessage()+"---" );
                        dengLu(deng);
                    }


                    break;
            }
        }
    };

    public void shibai(SiMode sim){
        if(sim.getMessage().contains("错误")){
            Toast.makeText(this,"用户名或密码错误，请重试",Toast.LENGTH_SHORT).show();
        }
    }

    public void dengLu(DengluMode dm){

            String message=dm.getMessage();
            if(message.contains("成功")){
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();

            FinalDb db=FinalDb.create(this);
            try{
                db.save(dm.getResultCode());
            }catch(Exception e){
                db.update(dm.getResultCode());
            }
                Message mess=new Message();
                Log.e("--***-9999999-***-",dm.getResultCode().getId());
//                mess.obj=dm.getResultCode().getId();
                 mess.obj=dm.getResultCode();
                mess.what=912;
                ((MyApplication) getApplication()).getAhandler().sendMessage(mess);
                Intent intent=new Intent();
                intent.putExtra("str",dm.getResultCode().getToken());
                setResult(55,intent);
                finish();
            }else if(message.contains("失败")){
                Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
            }else if(message.contains("错误")){
                Toast.makeText(this,"用户名或密码错误，请重试",Toast.LENGTH_SHORT).show();
            }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView= (TextView) findViewById(R.id.zhuce);
        editZH= (EditText) findViewById(R.id.zh);
        editMI= (EditText) findViewById(R.id.mm);
        button= (Button) findViewById(R.id.login);

        textView.setOnClickListener(this);
        button.setOnClickListener(this);
        radio= (RadioButton) findViewById(R.id.radioLogin);

    }

    @Override
    public void onClick(View view) {
        username=editZH.getText().toString().trim();
        mima=editMI.getText().toString().trim();


        switch (view.getId()){

            case R.id.login:

                if(!username.equals("") && !mima.equals("")){
                    HttpTools.getHttpTools().getPostZc(mhandler,username,mima,null,2);
                } else {
                    Toast.makeText(this,"账号和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zhuce:
                Intent intent =new Intent(Login.this,Zhuce.class);
                startActivity(intent);
                break;
        }
    }
}
