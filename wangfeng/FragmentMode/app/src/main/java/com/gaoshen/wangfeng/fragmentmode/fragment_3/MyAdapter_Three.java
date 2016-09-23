package com.gaoshen.wangfeng.fragmentmode.fragment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_3.Mode_3.ResultCodeBean;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import net.tsz.afinal.FinalBitmap;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class MyAdapter_Three extends BaseAdapter {

    private List<ResultCodeBean> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter_Three(Context context) {
        this.context = context;
    }

    //给ListView 添加数据
    public void setList(List<ResultCodeBean> list) {
        this.list=list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        this.layoutInflater= LayoutInflater.from(context);
        View view1=layoutInflater.inflate(R.layout.list_three_layout, null);
        TextView textView= (TextView) view1.findViewById(R.id.three_list_tit);
        ImageView imageView= (ImageView) view1.findViewById(R.id.yhImg);
        TextView daze= (TextView) view1.findViewById(R.id.zhezi);
        TextView neirong= (TextView) view1.findViewById(R.id.context);
        TextView address= (TextView) view1.findViewById(R.id.address_text);
        TextView juli= (TextView) view1.findViewById(R.id.jul_km);

        ImageView imgzhe= (ImageView) view1.findViewById(R.id.ze);

        textView.setText(list.get(i).getShopname());
        FinalBitmap fb=FinalBitmap.create(context);
        fb.display(imageView, BaseUrl.BASE+list.get(i).getPic());
        String str=list.get(i).getHuodong();
        if(str.contains("折")){
            imgzhe.setImageResource(R.mipmap.zk);
        }else{
            imgzhe.setImageResource(R.mipmap.mj);
        }
        daze.setText(list.get(i).getHuodong());
        neirong.setText(list.get(i).getContent());
        address.setText(list.get(i).getAddress());
        juli.setText(list.get(i).getJuli());
        return view1;
    }
}
