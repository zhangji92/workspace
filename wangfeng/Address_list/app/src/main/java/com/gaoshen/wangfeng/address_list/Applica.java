package com.gaoshen.wangfeng.address_list;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Mode.AddXingxi;

/**
 * Created by Administrator on 2016/8/15.
 */
public class Applica extends Application implements Serializable{


   private static int i;


    @Override
    public void onCreate() {
        super.onCreate();
        /**进入App后首先给 i 赋值
         *
         * 如果不是第一次使用该App  那就读取最后一次值
         */
        i =SharedUtil.getInt(Applica.this,"i",1);
    }

    /**
     *
     * @return
     */
    public static int getI(){
        return  i;
    }

    /**
     * i++ 操作
     */
    public static void update(){
        i++;
    }
}
