package com.gaoshen.wangfeng.activity_data_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.edit);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnClick();
            }
        });
    }

    public void setOnClick(){

        String string=editText.getText().toString().trim().replace("　","");
        FragmentText ft=new FragmentText();
        Bundle bd=new Bundle();
        bd.putString("str",string);
        ft.setArguments(bd);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ftn=fm.beginTransaction();
        ftn.add(R.id.frame,ft,"ft");
    }
}
