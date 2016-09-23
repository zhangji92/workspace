package com.gaoshen.wangfeng.fragmentmode.fragment_1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.gaoshen.wangfeng.fragmentmode.BaseFragment;
import com.gaoshen.wangfeng.fragmentmode.CustomList;
import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.Ad;
import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.Heng;
import com.gaoshen.wangfeng.fragmentmode.fragment_1.Mode_1.HomeFragment;
import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.util.BaseUrl;

import java.util.ArrayList;
import java.util.List;


/**
 * /进入应用
 * 将Fragment添加到Activity中---onAttach----------------------------------1
 * 创建Fragment---onCreate=====================================2
 * 绘制Fragment中的View组件---onCreateView
 * Fragment 所在的Activity 启动完成---onActivityCreated
 * 启动 Fragment ---onStart
 * 回复 Fragment ---onResume
 * <p>
 * /屏幕锁屏----> 到解屏
 * 暂停 Fragment ---onPause
 * 停止 Fragment ---onStop
 * 启动 Fragment ---onStart
 * 回复 Fragment ---onResume
 * <p>
 * /回到桌面
 * 暂停 Fragment ---onPause
 * 停止 Fragment ---onStop
 * <p>
 * /退出应用
 * 暂停 Fragment ---onPause
 * 停止 Fragment ---onStop
 * 销毁Fragment所包含的View组件 ---onDestroyView
 * 销毁Fragment ---onDestroy
 * Fragment 从Activity 中删除 ---onDetach
 */


/**
 * Created by Administrator on 2016/8/27.
 */
public class Fragment_one extends BaseFragment implements CustomList.IReflashListener {

    private TextView tit;//显示定位地址
    private ImageView one_img;//搜素图标
    private CustomList customList;//自定义ListView
    private MyAdapter myAdapter;//ListView适配器
    private ViewPageAdapter pageAdapter;//ViewPager控件适配器
    private ViewPager viewPager;//ViewPager控件
    private HomeFragment homeFragmentMode = null;//Fragment_one中所有数据
    private List<Heng> hengModes;
    List<Heng> yHeng=new ArrayList<>();//存放ListView中Item显示数据
    private List<Ad> adList;//存放广告
    private List<View> viewList;//存放ImageView控件
    private LocationClient mLocationClient = null;
    private MyLocationListener myLocationListener;

    private Handler mhandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case BaseUrl.CODE_A:
                    homeFragmentMode = getMode(msg.obj);



                    //ListView 相关业务逻辑处理
                    listItem();
//                    ViewPage相关业务逻辑处理
                    lunboInit();

                    break;
                case BaseUrl.CODE_B:
                    lunbo();
                    break;
                case BaseUrl.CODE_C:
                   String str= (String) msg.obj;
                    tit.setText(str);
            }
        }
    };

    /**
     * 为ListView设置原始数据
     */
    public void listItem() {

        hengModes = homeFragmentMode.getResultCode().getRecommend().getHeng();
        //循环集合中出最后两个的元素
        for (int i = 0; i <hengModes.size()-2 ; i++) {
            yHeng.add(hengModes.get(i)) ;
        }
        myAdapter.setList_Home(yHeng);
//        myAdapter.onDataChange(hengModes);
        Log.e("----666666666666----:", hengModes.get(0).getShopname());
        myAdapter.notifyDataSetChanged();
    }

    /**
     * 添加数据到ListView
     */
    @Override
    public void onReflash() {

        hengModes = homeFragmentMode.getResultCode().getRecommend().getHeng();
        //循环集合中出最后两个的元素
        for (int i = hengModes.size()-2; i <hengModes.size() ; i++) {
            yHeng.add(0,hengModes.get(i)) ;
        }
        myAdapter.notifyDataSetChanged();

        // 刷新数据完毕 通知listView
        customList.reflashComplete();
    }

    /**
     * 获取定位信息
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient=new LocationClient(getActivity().getApplicationContext());
        myLocationListener = new MyLocationListener();
        myLocationListener.setHandler(mhandle);
        initLocation();
        mLocationClient.registerLocationListener(myLocationListener);

        mLocationClient.start();


    }


    /**
     * 每次创建（Fragment） 都会绘制Fragemnt 的View 组件时回调该方法
     *
     * @param inflater           加载布局文件
     * @param container          加载Layout 布局的 父（ViewGroup）
     * @param savedInstanceState 是否返回父 ViewGroup  false 为不返回
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //获取父类onCreateView 的属性 httpTools

        //通过获取父类 httpTools 属性 调用 getData() 来获取数据
        httpTools.getDate(mhandle, "2", "1", BaseUrl.ONE,null);

        View view = inflater.inflate(R.layout.framment_1, container, false);
        tit = (TextView) view.findViewById(R.id.tit_text);
        one_img = (ImageView) view.findViewById(R.id.one_img);


        customList= (CustomList) view.findViewById(R.id.listV_CustomList);
        if (myAdapter == null) {
            myAdapter = new MyAdapter(getActivity());
            customList.setAdapter(myAdapter);
            customList.setInterface(this);//获取到listView的时候，给他设置一个接口
        }

        return view;
    }


    //解析数据
    public HomeFragment getMode(Object obj) {

        HomeFragment homeMode = null;
        if (obj != null && obj instanceof HomeFragment) {
            homeMode = (HomeFragment) obj;

        }

        return homeMode;
    }



    /**
     * 广告位适配器
     */
    public void lunboInit() {

        adList = homeFragmentMode.getResultCode().getAd();
        viewList = new ArrayList<>();
        for (int i = 0; i < adList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            viewList.add(imageView);
        }

        pageAdapter = new ViewPageAdapter(getActivity());
        viewPager = new ViewPager(getActivity());
//        adList = homeFragmentMode.getResultCode().getAd();
        //为适配器添加数据
        pageAdapter.setAdList(adList);
//        一个ImageView的 的集合
        pageAdapter.setViewList(viewList);

        viewPager.setAdapter(pageAdapter);
        pageAdapter.notifyDataSetChanged();
        mhandle.sendEmptyMessageDelayed(BaseUrl.CODE_B, 3000);

        layoutParams();
    }

    /**
     * 广告位 图片轮播
     */
    public void lunbo() {

        //当前的图片页数
        int item = viewPager.getCurrentItem();
        //当前页数等于最后一页时
        if (item == pageAdapter.getAdList().size() - 1) {
            //当前页数为0
            viewPager.setCurrentItem(0);
        } else {
            //当前页数+1
            viewPager.setCurrentItem(item + 1);
        }
        mhandle.sendEmptyMessageDelayed(BaseUrl.CODE_B, 3000);


    }

    /**
     * 设置布局参数，将viewPager 放入listView中
     */
    public void layoutParams() {
        //设定布局的宽度和高度
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 160);
        //把布局的高度和宽度设置给viewPager
        viewPager.setLayoutParams(layoutParams);

        customList.addHeaderView(viewPager);
    }



    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000*3600;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public Fragment_one() {
        super();
    }



}
