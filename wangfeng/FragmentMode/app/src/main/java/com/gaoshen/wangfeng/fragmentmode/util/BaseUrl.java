package com.gaoshen.wangfeng.fragmentmode.util;

/**
 * Created by Administrator on 2016/8/30.
 */
public class BaseUrl {


    /**
     * 通过一个地址 连接服务器（通过该地址获取服务器端的数据）
     */
    public final static String BASE="http://tc.ceol8.com/";
    public final static String HOME=BASE+"service/index.php?model=home&action=home_new";
    public final static String HOME_TOO=BASE+"service/index.php?model=city&action=indexcity";

    public final static String HOME_THREE=BASE+"service/index.php?model=favorable&action=favorableshoplist";

    public final static String ZHUCE=BASE+"service/index.php?model=user&action=register";


    public final static String YANZHENG=BASE+"service/index.php?model=user&action=verifycode";
    public final static String LOGIN=BASE+"service/index.php?model=user&action=login";

    public final static String USER=BASE+"service/index.php?model=user&action=edituser";

    public final static int ONE=1;
    public final static int TOO=2;
    public final static int THREE=3;
    public final static int YZM=4;
    public final static int ZHU=5;
    public final static int DENG=6;

    public final static int CODE_A=100;
    public final static int CODE_B=200;
    public final static int CODE_C=300;
    public final static int CODE_D=400;
    public final static int CODE_Y=500;
}
