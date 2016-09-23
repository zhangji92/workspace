package com.gaoshen.wangfeng.address_list;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class SysApplication {

    private List<Activity> mList = new LinkedList<Activity>();
    private static SysApplication instance;

    private SysApplication() {
    }
    //单例模式
    public synchronized static SysApplication getInstance() {
        if (null == instance) {
            instance = new SysApplication();
        }
        return instance;
    }
    // 添加Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    //退出程序
    public void exit() {
        try {
            //遍历list 集合
            for (Activity activity : mList) {
                //不为空的时候刷新
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);//关闭activity
        }
    }

}
