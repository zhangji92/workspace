package com.gaoshen.wangfeng.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private MyBind mybind=new MyBind();

    public MyService() {
    }
    //onBind
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("-------------"," 启动");
//        throw new UnsupportedOperationException("Not yet implemented");

        return mybind;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("-------------","onCreate: ");
       NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setContentTitle("逆相思");
        notification.setContentText("我是前台服务，laalal，oooo，1111");
        notification.setSmallIcon(R.mipmap.ic_launcher).getNotification();


        Intent intent=new Intent(this,MainActivity_too.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        notification.setContentIntent(pendingIntent);
        startForeground(2,notification.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("-------------","onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        //在停止前 调用该方法
        Log.e("----------", "onUnbind" );
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("-------------"," onDestroy()");
    }



    class MyBind extends Binder{

        public void undown(){
            Log.e("----", "开始下载");
        }

        public void rundown(){
            Log.e("----", "正在下载");
        }

    }

}
