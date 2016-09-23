package com.gaoshen.wangfeng.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
public class MyAdapter extends BaseAdapter {

    private List<Mode> mlist=null;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<Mode> listMd)
    {
        this.mlist = listMd;
        this.layoutInflater=layoutInflater.from(context);
    }

    /**
     * 如果数据改变了，界面也会随着改变
     * @param list
     */
    public void onDataChange(List<Mode> list){
        this.mlist=list;
        this.notifyDataSetChanged();//如果数据改变了添加数据后进行刷新
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.activity_list_xiangq, null);
            viewHolder.text1 = (TextView) view.findViewById(R.id.tex1);
            viewHolder.text2 = (TextView) view.findViewById(R.id.tex2);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Mode mode=mlist.get(i);
        viewHolder.text1.setText(mode.getTit());
        viewHolder.text2.setText(mode.getMasg());
        return view;
    }
    private class ViewHolder {

        public TextView text1;
        public TextView text2;
    }
}
