package com.gaoshen.wangfeng.fragmentmode.fragment_3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.BaseFragment;
import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.CustomList;
import com.gaoshen.wangfeng.fragmentmode.fragment_3.Mode_3.ResultCodeBean;
import com.gaoshen.wangfeng.fragmentmode.fragment_3.Mode_3.ThreeFragment;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Fragment_three extends BaseFragment implements CustomList.IReflashListener{

    private TextView textView3;
    private CustomList listView_three;
    private ThreeFragment threeFragment;
    protected List<ResultCodeBean> resultCode;
    protected List<ResultCodeBean> resultCode2=new ArrayList<>();

    private MyAdapter_Three myAdapter_Three;

    private Handler threeHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  BaseUrl.THREE:
                    threeFragment=getModeToo(msg.obj);
                    init();

            }
        }
    };
    /**
     * 获取服务 中的数据 即填充ListView 的数据
     * @param obj
     * @return
     */
    public ThreeFragment getModeToo(Object obj){
       ThreeFragment too=null;
        if (obj!=null&& obj instanceof  ThreeFragment){
            too= (ThreeFragment) obj;
            Log.e("handleMessa======:",too.getResultCode().get(1).getShopname());
        }

        return too;
    }

    public void init(){
        resultCode=threeFragment.getResultCode();
        for (int i = 0; i <resultCode.size()-2 ; i++) {
            resultCode2.add(resultCode.get(i));
        }
        myAdapter_Three.setList(resultCode2);
        myAdapter_Three.notifyDataSetChanged();
    }
public void addData(){
    resultCode=threeFragment.getResultCode();
    for (int i =resultCode.size()-2; i <resultCode.size() ; i++) {
        resultCode2.add(0,resultCode.get(i));
    }
}
    @Override
    public void onReflash() {
        addData();
        myAdapter_Three.notifyDataSetChanged();
        listView_three.reflashComplete();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        httpTools.getDatePost(threeHandler,"3","2");

        View view=inflater.inflate(R.layout.framment_3,container,false);
        textView3= (TextView) view.findViewById(R.id.tit_text);
        textView3.setText("优惠专区");
        listView_three= (CustomList) view.findViewById(R.id.list_three);
        myAdapter_Three=new MyAdapter_Three(getActivity());

        listView_three.setAdapter(myAdapter_Three);
        listView_three.setInterface(this);


        return view;
    }


}