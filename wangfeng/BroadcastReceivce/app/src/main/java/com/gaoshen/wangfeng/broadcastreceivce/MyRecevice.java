package com.gaoshen.wangfeng.broadcastreceivce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/8.
 */
public class MyRecevice extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.app01.testBroadcastReceiver"))
        Toast.makeText(context,"(优低)-接收到了另一个程序的广播",Toast.LENGTH_SHORT).show();
    }
}
