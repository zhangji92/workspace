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
import android.widget.Toast;

import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.SiMode;

import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;
import com.gaoshen.wangfeng.fragmentmode.util.HttpTools;

public class Zhuce extends AppCompatActivity implements View.OnClickListener {

    private EditText editSj, editYZ, editMM;
    private Button butYz, butZc,butdl;
    private SiMode si;
    private SiMode si2;
    String str;

    private Handler shandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case BaseUrl.CODE_Y:
                    si = (SiMode) msg.obj;
                    Log.e("handleMessage:---验证码-- ", si.getResultCode());
                    break;
                case BaseUrl.ZHU:
                    si2 = (SiMode) msg.obj;
                    message(si2);
                    Log.e("handleMessage:---注册码-- ", si2.getResultCode()+"---"+si2.getMessage());
                    break;
            }
        }
    };

    public void   message(SiMode si2){
        Toast.makeText(this,"注册"+si2.getMessage(), Toast.LENGTH_SHORT).show();
        if(si2.getMessage().equals("成功")){
            Intent intent =new Intent(this,Login.class);
            startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        editSj = (EditText) findViewById(R.id.shouji);
        editYZ = (EditText) findViewById(R.id.yanzm);
        editMM = (EditText) findViewById(R.id.zmm);
        butYz = (Button) findViewById(R.id.yanzhenma);
        butZc = (Button) findViewById(R.id.ljzc);
        butdl = (Button) findViewById(R.id.lkdl);

        butYz.setOnClickListener(this);
        butZc.setOnClickListener(this);
        butdl.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String sj = editSj.getText().toString().trim();
        String yanzm = editYZ.getText().toString().trim();
        String mia = editMM.getText().toString().trim();

        switch (view.getId()) {
            case R.id.yanzhenma:
                if (sj != null && !sj.equals("")) {
                    HttpTools.getHttpTools().getDate(shandle, null,null,BaseUrl.YZM, sj);
                } else {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.ljzc:

                if (!sj.equals("") && !yanzm.equals("") && !mia.equals("")) {

                    if (si.getResultCode().equals(yanzm)) {
                        HttpTools.getHttpTools().getPostZc(shandle, sj, mia, yanzm,1);

                    } else {
                        Toast.makeText(this,"失败", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "请填写未填项", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.lkdl:
                Intent intent =new Intent(this,Login.class);
                startActivity(intent);

        }
    }
}
