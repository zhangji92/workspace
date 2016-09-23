package com.gaoshen.wangfeng.wang_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dialog_tuichu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_tuichu);
    }
    public void ddd(View view){
        LinearLayout li=(LinearLayout) getLayoutInflater().inflate(R.layout.activity_tuichu_2,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(Dialog_tuichu.this);
        builder.setView(li);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });



        builder.create().show();
    }
}
