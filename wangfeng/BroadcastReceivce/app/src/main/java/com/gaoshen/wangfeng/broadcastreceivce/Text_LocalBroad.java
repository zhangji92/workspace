package com.gaoshen.wangfeng.broadcastreceivce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Text_LocalBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.app01.testBroadcastReceiver")){
            Toast.makeText(context, "获取到其他应用本地广播", Toast.LENGTH_SHORT).show();
        }
    }
}
