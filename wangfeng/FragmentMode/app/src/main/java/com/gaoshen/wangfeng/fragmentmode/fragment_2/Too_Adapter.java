package com.gaoshen.wangfeng.fragmentmode.fragment_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.fragment_2.Mode_2.ResultCodeBean;
import com.gaoshen.wangfeng.fragmentmode.R;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;

import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Too_Adapter extends BaseAdapter {

    private List<ResultCodeBean> resultCodeBeen=new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public Too_Adapter(Context context){
        this.context=context;

    }

    public void setResultCodeBeen(List<ResultCodeBean> resultCodeBeen) {
        this.resultCodeBeen = resultCodeBeen;
    }

    @Override
    public int getCount() {
        return resultCodeBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return resultCodeBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater=LayoutInflater.from(context);
        View vi=layoutInflater.inflate(R.layout.list_too_layout,null);
        ImageView img= (ImageView) vi.findViewById(R.id.play_son_img);
        TextView title= (TextView) vi.findViewById(R.id.play_son_title);
        TextView dan= (TextView) vi.findViewById(R.id.play_son_no);
        TextView address= (TextView) vi.findViewById(R.id.play_son_add);
        TextView con= (TextView) vi.findViewById(R.id.play_son_context);
        TextView juli= (TextView) vi.findViewById(R.id.jl);


        FinalBitmap fb=FinalBitmap.create(context);
        fb.display(img, BaseUrl.BASE + resultCodeBeen.get(i).getPic());
        title.setText(resultCodeBeen.get(i).getShopname());
        dan.setText(resultCodeBeen.get(i).getOrdernum());
        address.setText(resultCodeBeen.get(i).getAddress());
        con.setText(resultCodeBeen.get(i).getContent());
        juli.setText(resultCodeBeen.get(i).getJuli());
        return vi;
    }
}
