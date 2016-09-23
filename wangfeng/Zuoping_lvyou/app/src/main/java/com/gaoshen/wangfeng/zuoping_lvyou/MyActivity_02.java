package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyActivity_02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_02);
    }

    public void skippage(View view){

        switch (view.getId()){
            case R.id.i1:
                skip(MyActivity_02.this,My_Activity_03.class);
                break;

            case R.id.i8:
                Intent intent =new Intent(MyActivity_02.this,MyActivity_laoshi.class);
                startActivity(intent);
        }
    }

    /**跳转
     *
     * @param myActivity_02  当前页
     * @param m_activity_03Class  跳转页
     */
    private void skip(MyActivity_02 myActivity_02, Class<My_Activity_03> m_activity_03Class) {
        Intent intent =new Intent(myActivity_02,m_activity_03Class);
        startActivity(intent);
    }
}
