package com.gaoshen.wangfeng.mmmmmm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {


    View v;
    Toolbar toolb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.mmm,container,false);
        v=inflate.findViewById(R.id.new_ff);
       toolb= (Toolbar) v.findViewById(R.id.tool);
        toolb.setTitle("aaaaaaaaaaaaa");
        return inflate;
    }
}
