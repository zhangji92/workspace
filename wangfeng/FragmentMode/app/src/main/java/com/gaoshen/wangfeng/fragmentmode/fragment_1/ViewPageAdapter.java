package com.gaoshen.wangfeng.fragmentmode.fragment_1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.Ad;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import net.tsz.afinal.FinalBitmap;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public class ViewPageAdapter extends PagerAdapter{

    private List<Ad> adList;
    private List<View> viewList;
    private FinalBitmap fb;


    /**
     * 创建对象时 初始化赋值
     */
    public ViewPageAdapter(Context context){
        fb=FinalBitmap.create(context);
    }

    public void setAdList(List<Ad> adList){
        this.adList=adList;
    }

    public List<Ad> getAdList() {
        return adList;
    }

    public void setFb(FinalBitmap fb) {
        this.fb = fb;
    }

    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return adList==null?0:adList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView= (ImageView) viewList.get(position);
        fb.display(imageView, BaseUrl.BASE+adList.get(position).getPic());
        container.addView(imageView);
        return imageView;
    }
}


