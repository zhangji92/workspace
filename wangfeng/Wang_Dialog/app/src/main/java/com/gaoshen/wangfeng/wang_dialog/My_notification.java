package com.gaoshen.wangfeng.wang_dialog;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.widget.Button;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class My_notification extends AppCompatActivity {

    static final int NOTIFICATION_ID = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);

    }


    public void send(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.xiaoyang);//设置小图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.xiaoyang));//设置大图标
        builder.setContentTitle("这是标题");//设置通知栏内容（即标题）
        builder.setContentText("这个是内容");
        builder.setSubText("这个是二级内容");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // 设置当用户点击时，执行用户操作。
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());


//        builder.setDefaults(Notification.DEFAULT_SOUND);//设置提示音
//        builder.setDefaults(Notification.DEFAULT_LIGHTS);//设置指示灯
//        builder.setDefaults(Notification.DEFAULT_VIBRATE);//设置震动
//        builder.setDefaults(Notification.DEFAULT_ALL);//设置提示音 ,指示灯 ,震动
//


    }
}
