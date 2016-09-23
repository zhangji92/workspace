package com.gaoshen.wangfeng.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Left2 extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.left2,container,false);
        Log.i("----2----","绘制Fragment中的View组件---onCreateView");
        textView= (TextView) view.findViewById(R.id.left2);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("----2----","将Fragment添加到Activity中---onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("----2----","创建Fragment---onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("----2----","Fragment 所在的Activity 启动完成---onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("----2----"," 启动 Fragment ---onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("----2----"," 恢复 Fragment ---onResume");
    }

    /**
     * 暂停Fragment时被 回调
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.i("----2----"," 暂停 Fragment ---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("----2----"," 停止 Fragment ---onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("----2----"," 销毁Fragment所包含的View组件 ---onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("----2----"," 销毁Fragment ---onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("----2----"," Fragment 从Activity 中删除 ---onDetach");
    }
}
