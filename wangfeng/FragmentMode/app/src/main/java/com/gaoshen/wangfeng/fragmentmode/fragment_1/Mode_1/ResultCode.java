package com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public class ResultCode {


    private List<Ad> ad;

    private Recommend recommend;


    public ResultCode() {
    }

    public ResultCode(List<Ad> ad, Recommend recommend) {
        this.ad = ad;
        this.recommend = recommend;
    }

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }

    public Recommend getRecommend() {
        return recommend;
    }

    public void setRecommend(Recommend recommendMode) {
        this.recommend = recommend;
    }
}
