package com.gaoshen.wangfeng.fragmentmode.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.HomeFragment;
import com.gaoshen.wangfeng.fragmentmode.fragment_2.Mode_2.TooFragment;
import com.gaoshen.wangfeng.fragmentmode.fragment_3.Mode_3.ThreeFragment;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.SiMode;
import com.google.gson.Gson;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HttpTools {

    static FinalHttp finalhttp;
    static HttpTools httpTools;

    String url = "";//服务地址
    int ma = 0;//标识码

    private HttpTools() {
        finalhttp = new FinalHttp();
    }

    public static HttpTools getHttpTools() {
        if (httpTools == null) {
            return httpTools = new HttpTools();
        }
        return httpTools;
    }

    /**
     * lat	N	string	维度
     * lng	N	string	经度
     * searcename
     */
    public void getDate(final Handler handler, String lat, String lng, final int i, String sj) {


        /**
         * 通过 i值进行判断 获取服务数据
         * ONE 首页数据标识
         */
        if (i == BaseUrl.ONE) {
            url = BaseUrl.HOME + "&lat=" + lat + "&lng=" + lng;
            ma = BaseUrl.CODE_A;
        } else if (i == BaseUrl.TOO) {
            url = BaseUrl.HOME_TOO + "&lat=" + lat + "&lng=" + lng;
            ma = BaseUrl.CODE_D;
        } else if (i == BaseUrl.YZM) {
            url = BaseUrl.YANZHENG + "&mobile=" + sj;
            ma = BaseUrl.CODE_Y;
        }
        finalhttp.get(url, new AjaxCallBack<String>() {

            @Override
            public void onStart() {
                Log.i("HttpTools", "------启动");
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Log.i("HttpTools", "---成功---" + s);

                Gson gson = new Gson();
                Message mes = new Message();

                if (i == BaseUrl.ONE) {
                    HomeFragment homeFragmentMode = gson.fromJson(s, HomeFragment.class);
                    mes.obj = homeFragmentMode;
                } else if (i == BaseUrl.TOO) {
                    TooFragment tooFragment = gson.fromJson(s, TooFragment.class);
                    mes.obj = tooFragment;
                } else if (i == BaseUrl.YZM) {

                    SiMode si = gson.fromJson(s, SiMode.class);
                    mes.obj = si;
                }

                mes.what = ma;
                handler.sendMessage(mes);


                Log.i("HttpTools", "---成功--" + mes.obj + "--");
            }


            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                Log.i("HttpTools", "-----失败" + strMsg);
                super.onFailure(t, errorNo, strMsg);
            }
        });


    }

    public void getDatePost(final Handler handler, String lat, String lng) {

        String uri = BaseUrl.HOME_THREE + "&lat=" + lat + "&lng=" + lng;
        finalhttp.post(uri, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                Log.i("HttpTools", "--post----启动");
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Log.e("onSuccess:----****---- ", s);
                Message message = new Message();

                Gson gson = new Gson();
                ThreeFragment threeFragment = gson.fromJson(s, ThreeFragment.class);
                message.obj = threeFragment;
                message.what = BaseUrl.THREE;
                handler.sendMessage(message);
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

    /**
     * 注册    登录
     * username	是	string	用户名
     * passwd	是	string	密码
     * code
     */
    public void getPostZc(final Handler handler, String username, String passwd, String code, final int i) {


        final Map<String, String> map = new HashMap<>();
        if (i == 1) {
            map.put("code", code);
            map.put("username", username);
            map.put("passwd", passwd);
            url = BaseUrl.ZHUCE;
            ma = BaseUrl.ZHU;
        } else if (i == 2) {
            map.put("username", username);
            map.put("passwd", passwd);
            url = BaseUrl.LOGIN;
            ma = BaseUrl.DENG;
        }


        finalhttp.post(url, new AjaxParams(map), new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                if (i == 1) {
                    Log.i("HttpTools", "--注册----启动");
                } else if (i == 2) {
                    Log.i("HttpTools", "--登录----启动");
                }

                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                if (i == 1) {
                    Log.i("HttpTools", "--注册----" + s);
                } else if (i == 2) {
                    Log.i("HttpTools", "--登录----" + s);
                }

                Message message = new Message();
                Gson gson = new Gson();
                if (i == 1) {

                    SiMode siMode = gson.fromJson(s, SiMode.class);
                    message.obj = siMode;

                } else if (i == 2) {
                    message.obj = s;
                    Log.e("---********",s );
                }
                message.what = ma;
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                if (i == 1) {
                    Log.i("HttpTools", "--注册失败----" + strMsg);
                } else if (i == 2) {
                    Log.i("HttpTools", "--登录失败----" + strMsg);
                }

            }
        });
    }


    /**
     * token	是	string	用户token
     * nickname	是	string	昵称
     * gender	否	string	性别 1男 2女
     * age	否	string	年龄
     * address	否	string	地址
     * pics	否	string	头像地址
     */
    public void setUser(final Handler handler, String token, String nickname, String gender, String age, String address, String pics) {
        final Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("nickname", nickname);
        map.put("gender", gender);
        map.put("age", age);
        map.put("address", address);
        map.put("pics", pics);


        url = BaseUrl.USER;
        finalhttp.post(url, new AjaxParams(map), new AjaxCallBack<String>() {

            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Log.e("--****--user--***----",s );
                Message mse=new Message();
                mse.obj=s;
                mse.what=666;
                handler.sendMessage(mse);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }
}
