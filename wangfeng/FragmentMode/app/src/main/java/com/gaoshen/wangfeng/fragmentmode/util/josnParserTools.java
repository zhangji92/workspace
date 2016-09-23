package com.gaoshen.wangfeng.fragmentmode.util;

import com.google.gson.Gson;

import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.HomeFragment;

/**
 * Created by Administrator on 2016/8/31.
 */
public class josnParserTools {

    public static HomeFragment parser(String s){
        HomeFragment home=null;
        if (s!=null){
            Gson gson=new Gson();
            home= gson.fromJson(s, HomeFragment.class);
        }

        return  home;
    }
}
