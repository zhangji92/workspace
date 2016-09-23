package com.gaoshen.wangfeng.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentService 生命周期：
 *  onCreate()
 *  onStartCommand（）
 *  onStart()
 *  onHandleIntent()
 *  onDestroy()
 */
public class MyIntentService_too extends IntentService {

    public MyIntentService_too() {
        super("MyIntentService_too");

    }

    public MyIntentService_too(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("onCreate","--onCreate()" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("onStartCommand","--onStartCommand" );
        Log.e("onStartCommand","--主线程"+Thread.currentThread().getId() );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("onHandleIntent","--onHandleIntent" );
        Log.e("onHandleIntent","--子线程"+Thread.currentThread().getId() );
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("onStart","--onStart" );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy","--onDestroy" );
    }

}
