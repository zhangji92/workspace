package com.gaoshen.wangfeng.activity_data_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoshen.wangfeng.activity_data_fragment.R;

/**
 * Created by Administrator on 2016/8/29.
 */
public class FragmentText extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_text,container,false);
        textView= (TextView) view.findViewById(R.id.text);
        return view;
    }
}
