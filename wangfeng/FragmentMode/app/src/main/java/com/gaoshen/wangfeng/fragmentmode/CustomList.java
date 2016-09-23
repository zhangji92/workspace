package com.gaoshen.wangfeng.fragmentmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/1.
 */
public class CustomList extends ListView implements AbsListView.OnScrollListener{

    View header;//顶部布局文件
    int headerHeight;//header布局文件的高度

    int i;//当前第一个可见item的位置

    boolean isRemark;//标记，当前是在listView最顶端摁下的
    int startY;//listView在最顶端时 ，摁下时的y值;
    int srcollState;//listView 当前滚动状态

    int state;//当前状态、
    final int NONE = 0;//正常状态
    final int PULL = 1;//提示下拉状态
    final int RELESE = 2;//提示释放状态
    final int REFLASHING = 3;//刷新状态


    IReflashListener iReflashListener;//刷新数据的接口

    public CustomList(Context context) {
        super(context);
        init(context);
    }

    public CustomList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //获取顶部文件
        header = layoutInflater.inflate(R.layout.activity_header, null);
        //测量header在父布局中的宽高
        measureView(header);
        //获取测量以后header的高度
        headerHeight = header.getMeasuredHeight();
//        设置顶部文件的 顶部内边距
        topPadding(-headerHeight);
        //将顶部布局文件添加到ListView中
        this.addHeaderView(header);
        this.setOnScrollListener(this);



    }
    /**
     * 通知父布局，顶部布局占用的宽，高
     *
     * @param view
     */
    private void measureView(View view) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        //获取子类布局规格的 高
        int width = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int height;
        int tempHeight = p.height;
        if (tempHeight > 0) {
            //    EXACTLY 父容器已经检测出VIew所需要的精确大小，这个时候View的最终大小就是StempHeight所指定的值
            height = MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY);
        } else {
            //高度为0的时候不添加内容
            //  UnSpecified  父容器不对View有任何限制，要多大给多大（测量可以测出来但是显示不出来）
            height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        view.measure(width, height);
    }

    /**
     * 设置顶部文件的 顶部内边距
     *
     * @param topPad
     */
    private void topPadding(int topPad) {

        //设置顶部文件的  顶部边距
        header.setPadding(header.getPaddingLeft(), topPad, header.getPaddingRight(), header.getPaddingBottom());
        //设置之后 重新绘制顶部布局文件
        header.invalidate();
    }

    /**
     *
     * @param absListView
     * @param i  当前j界面第一个可见item的位置
     * @param i1
     * @param i2
     */
    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        this.i = i;
    }

    /**
     * @param absListView
     * @param i
     */
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.srcollState = i;
    }


    /**
     * 监听 手势事件
     *
     * @param ev 手势动作
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN://按下
                if (i == 0) {//判断是否在界面最顶端
                    isRemark = true;
                    startY = (int) ev.getY();//记录Y值
                }
                break;
            case MotionEvent.ACTION_MOVE://移动
                onMove(ev);
                break;
            case MotionEvent.ACTION_UP://抬起
                if (state == RELESE) {
                    state = REFLASHING;
                    //加载最新数据
                    flashView();//状态发生改变时 改变界面显示
                    //接口回调方式 将ListView中的数据显示到界面
                    iReflashListener.onReflash();


                } else if (state == PULL) {
                    state = NONE;
                    isRemark = false;
                    flashView();//状态发生改变时 改变界面显示

                }
                reflashComplete();
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 判断移动过程中的动作
     *
     * @param ev
     */
    public void onMove(MotionEvent ev) {

        //如果没有按下 就不会移动 不执行移动操作
        if (!isRemark) {//表示 没有按下
            return;
        }

        int tempY = (int) ev.getY();//移动位置
        int space = tempY - startY;//移动距离
        //在移动的过程中不断设置顶部布局的topPadding
        int topPadding = space - headerHeight;

        //移动过程中的状态是不断变化的
        switch (state) {
            case NONE:

                if (space > 0) {//如果移动的距离大于0，表示在下拉
                    state = PULL;//由正常状态转变为下拉状态
                    flashView();//状态发生改变时 改变界面显示e
                }
                break;
            case PULL://下拉状态
                topPadding(topPadding);
                //下拉高度大于一定高度的时候  并且是正在滚动
                if (space > headerHeight + 50 && srcollState == SCROLL_STATE_TOUCH_SCROLL) {
                    state = RELESE; //状态变为释放可以刷新状态
                    flashView();//状态发生改变时 改变界面显示
                }
                break;
            case RELESE://释放状态
                topPadding(topPadding);
                if (space < headerHeight + 50) { //当高度小于 最大高度的时候
                    state = PULL;//由正常状态转变为下拉状态
                    flashView();//状态发生改变时 改变界面显示
                } else if (space <= 0) {
                    state = NONE;
                    isRemark = false;
                    flashView();//状态发生改变时 改变界面显示
                }
                break;

        }

    }
        /**
         * 根据当前状态，改变界面显示
         */
    private void flashView() {
        //提示文字
        TextView tip = (TextView) header.findViewById(R.id.tip);
        ImageView jt = (ImageView) header.findViewById(R.id.xiaj);
        ProgressBar progressBar = (ProgressBar) header.findViewById(R.id.progress);
        //给箭头添加动画
        RotateAnimation anim1 = new RotateAnimation(0, 180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        anim1.setDuration(100);//设置时间间隔
        anim1.setFillAfter(true);//保留在停止位
        RotateAnimation anim2 = new RotateAnimation(180, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        anim2.setDuration(100);//设置时间间隔
        anim2.setFillAfter(true);

        switch (state) {
            case NONE:
                topPadding(-headerHeight);
                break;
            case PULL://下拉刷新
                jt.setVisibility(View.VISIBLE);//设置箭头为显示
                progressBar.setVisibility(View.GONE);//设置进度条为隐藏
                tip.setText("下拉可以刷新");
                jt.clearAnimation();//清空动画
                jt.setAnimation(anim2);//箭头向下
                break;
            case RELESE://松开刷新
                jt.setVisibility(View.VISIBLE);//设置箭头为显示
                progressBar.setVisibility(View.GONE);//设置进度条为隐藏
                tip.setText("松开可以刷新");
                jt.clearAnimation();//清空动画
                jt.setAnimation(anim1);
                break;
            case REFLASHING://正在刷新
                topPadding(50);//正在刷新时有一个固定的高度
                jt.setVisibility(View.GONE);//设置箭头为隐藏
                progressBar.setVisibility(View.VISIBLE);//设置进度条为显示
                tip.setText("正在刷新...");
                reflashComplete();
                break;

        }
    }

    /**
     * 获取玩数据
     *
     * 让顶部布局回到初始状态
     */
    public void reflashComplete() {
        state = NONE;
        isRemark = false;
        flashView();
        //设置上次刷新时间
        TextView la = (TextView) header.findViewById(R.id.lastupdate_time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String time = sd.format(date);
        la.setText(time);

    }

    /**通过该方法 调用接口中的onReflash()方法
     *
     * @param iReflashListener
     */
    public void setInterface(IReflashListener iReflashListener) {
        this.iReflashListener = iReflashListener;//设置值
    }

    /**
     * 刷新数据的接口
     */
    public interface IReflashListener {
        void onReflash();
    }


}
