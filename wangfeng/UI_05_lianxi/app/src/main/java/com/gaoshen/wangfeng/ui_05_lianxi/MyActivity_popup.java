package com.gaoshen.wangfeng.ui_05_lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MyActivity_popup extends AppCompatActivity {


    private Button but;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_popup);

        but = (Button) findViewById(R.id.button);
        img = (ImageView) findViewById(R.id.image);
        registerForContextMenu(but);
        

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.popup_wang, menu);

    }



    public void onPopupButtonClick(View image) {

 final PopupMenu popupMenu=new PopupMenu(MyActivity_popup.this,img);
getMenuInflater().inflate(R.menu.popup_wang,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.tit1:
                        popupMenu.dismiss();
                        break;

                    default:
                        Toast.makeText(MyActivity_popup.this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT);
                }
                return true;
            }
        });
        popupMenu.show();
    }
    }

