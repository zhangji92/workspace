package com.gaoshen.wangfeng.fragmentmode.fragment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.Heng;
import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import net.tsz.afinal.FinalBitmap;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public class MyAdapter extends BaseAdapter {

    private List<Heng> list_Home;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter(Context context) {

        this.context = context;

        layoutInflater = LayoutInflater.from(context);
    }

    public void setList_Home(List<Heng> list_Home) {
        this.list_Home=list_Home;
    }

//    /**
//     * 如果数据改变了，界面也会随着改变
//     * @param list
//     */
//    public void onDataChange(List<Heng> list){
//        this.list_Home=list;
//        this.notifyDataSetChanged();//如果数据改变了添加数据后进行刷新
//    }

    @Override
    public int getCount() {
        return list_Home == null ? 0 : list_Home.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(context, R.layout.list_layout, null);
        ImageView img = (ImageView) v.findViewById(R.id.list_img);
        FinalBitmap fb = FinalBitmap.create(context);
        fb.display(img, BaseUrl.BASE + list_Home.get(i).getPic());

        TextView t = (TextView) v.findViewById(R.id.name);
        t.setText(list_Home.get(i).getBusinessname());

        TextView t2 = (TextView) v.findViewById(R.id.count);
        t2.setText(list_Home.get(i).getAddress());

        return v;
    }


}
