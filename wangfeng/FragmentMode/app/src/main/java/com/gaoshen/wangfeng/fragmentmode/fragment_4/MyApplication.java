package com.gaoshen.wangfeng.fragmentmode.fragment_4;

import android.app.Application;
import android.os.Handler;

import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.ResultCodeBean;

/**
 * Created by Administrator on 2016/9/6.
 */
public class MyApplication extends Application {

    private String id;
    private Handler Ahandler;
//    private String token;
    private ResultCodeBean codeBeen;


//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }


    public ResultCodeBean getCodeBeen() {
        return codeBeen;
    }

    public void setCodeBeen(ResultCodeBean codeBeen) {
        this.codeBeen = codeBeen;
    }

    public Handler getAhandler() {
        return Ahandler;
    }

    public void setAhandler(Handler ahandler) {
        Ahandler = ahandler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
