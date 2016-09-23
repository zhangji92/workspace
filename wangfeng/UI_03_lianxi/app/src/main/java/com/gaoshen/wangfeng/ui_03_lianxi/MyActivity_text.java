package com.gaoshen.wangfeng.ui_03_lianxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity_text extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_text);

        editText=(EditText) findViewById(R.id.editView);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled=false;
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    sendMessage();
                    handled=true;
                }
                return handled;
            }

            public void sendMessage(){
                Intent intent=new Intent(MyActivity_text.this,MyActivity_stley.class);
                String message=editText.getText().toString();
                intent.putExtra("message",message);
                startActivity(intent);
            }
        });

    }

}
