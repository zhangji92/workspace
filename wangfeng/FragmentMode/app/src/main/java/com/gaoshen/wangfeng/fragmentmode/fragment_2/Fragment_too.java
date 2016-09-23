package com.gaoshen.wangfeng.fragmentmode.fragment_2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.BaseFragment;
import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_2.Mode_2.ResultCodeBean;
import com.gaoshen.wangfeng.fragmentmode.fragment_2.Mode_2.TooFragment;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Fragment_too extends BaseFragment {


    private TextView tit_too;
    private ListView listView_too;
    private TooFragment tooFragment = null;
    private List<ResultCodeBean> resultCodeBean;
    private Too_Adapter too_adapter;
    private ScrollView scrollView;
    int jin;
    int wei;


    private Handler toohandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case BaseUrl.CODE_D:
                    tooFragment = getModeToo(msg.obj);
                    resultCodeBean = tooFragment.getResultCode();
                    Log.e("----222222222----",resultCodeBean.get(1).getShopname() );
                    too_adapter.setResultCodeBeen(resultCodeBean);
                    getViewHright(listView_too);
                    too_adapter.notifyDataSetChanged();
                case BaseUrl.CODE_C:
                    wei = msg.arg2;
            }
        }
    };

    /**
     * 获取服务 中的数据 即填充ListView 的数据
     *
     * @param obj
     * @return
     */
    public TooFragment getModeToo(Object obj) {
        TooFragment too = null;
        if (obj != null && obj instanceof TooFragment) {
            too = (TooFragment) obj;
        }
        return too;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过获取父类 httpTools 属性 调用 getData() 来获取数据
        httpTools.getDate(toohandler, String.valueOf(jin), String.valueOf(wei), BaseUrl.TOO, null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framment_2, container, false);
        tit_too = (TextView) view.findViewById(R.id.tit_text);
        scrollView = (ScrollView) view.findViewById(R.id.scroll);
        tit_too.setText("同城爱玩");
        listView_too = (ListView) view.findViewById(R.id.play_list);
        too_adapter = new Too_Adapter(getActivity());

        listView_too.setAdapter(too_adapter);

       RelativeLayout zhiding= (RelativeLayout) view.findViewById(R.id.scroll_relative);
        zhiding.setFocusable(true);
        zhiding.setFocusableInTouchMode(true);
        zhiding.requestFocus();

        return view;
    }

    /**
     * 测量ListView的高度
     * @param listView
     */
    public void getViewHright(ListView listView) {

        Adapter adapter=listView.getAdapter();
        int gd=0;
        for(int i=0;i<adapter.getCount();i++){
            View view=adapter.getView(i,null,listView);
            view.measure(0,0);
            int item=view.getMeasuredHeight();
            gd+=item;
        }
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height=gd+(listView.getDividerHeight()*(adapter.getCount()-1));
        listView.setLayoutParams(params);
    }

}
