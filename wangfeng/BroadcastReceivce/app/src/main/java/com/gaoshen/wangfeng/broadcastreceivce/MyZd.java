package com.gaoshen.wangfeng.broadcastreceivce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/8.
 */
public class MyZd extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.app01.abortBroadcast")){
            Toast.makeText(context,"中断后接受广播",Toast.LENGTH_SHORT).show();
        }
    }
}
