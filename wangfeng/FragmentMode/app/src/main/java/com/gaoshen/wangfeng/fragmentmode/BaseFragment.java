package com.gaoshen.wangfeng.fragmentmode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.gaoshen.wangfeng.fragmentmode.util.HttpTools;


public abstract class BaseFragment extends Fragment {



    public HttpTools httpTools;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpTools= HttpTools.getHttpTools();
    }


}
