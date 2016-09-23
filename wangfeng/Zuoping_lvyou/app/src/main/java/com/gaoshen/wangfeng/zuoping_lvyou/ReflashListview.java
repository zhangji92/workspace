package com.gaoshen.wangfeng.zuoping_lvyou;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/6/26.
 */
public class ReflashListview extends ListView implements AbsListView.OnScrollListener {

    //顶部布局文件
    View header;
    //顶部布局文件的高度
    int headerHeight;
    //当前界面第一个可见的item的位置（第一个Listview 元素）
    int firstVisibleItem;
    //listView 当前的滚动状态
    int scrollState;
    //标记，当前是在listView最顶端按下的
    boolean isRemark;
    int startY;//摁下时的y值

    int state;//当前状态
    final int NONE=0; //正常状态
    final int PULL=1;//提示下拉状态
    final int RELESE=2;//提示释放状态；
    final int REFLASHING=3;//刷新状态

    //重写ListView的构造方法
    public ReflashListview(Context context) {
        super(context);
        initView(context);
    }

    public ReflashListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ReflashListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化界面，添加顶部布局文件到 listView
     *
     * @param context
     */
    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //通过inflater 来获取 header 文件
        header = inflater.inflate(R.layout.header, null);
        //通知父布局  占用的宽 高
        measureView(header);
        //获取header 高度
        headerHeight = header.getMeasuredHeight();
        //设置header 的顶部距离为 -的header布局的高度  实现隐藏header
        tooPadding(-headerHeight);
        //添加 顶部文件 到listView
        this.addHeaderView(header);
        //添加滚动监听
        this.setOnScrollListener(this);

    }

    /**
     * 通知父布局  占用的宽 高
     *
     * @param view
     */
    private void measureView(View view) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        //获取子布局的宽度  第一个参数-->header左右的边距   第二个参数-->header的内边距
        //第三个参数 子布局的宽度
        int width = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int height;
        int tempHeight = p.height;
        if (tempHeight > 0) {
            //高度不为空 填充header 布局
            height = MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY);
        } else {
            //高度是0的时候就不需要填充它
            height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        view.measure(width, height);
    }

    /**
     * 设置header 布局的上边距
     *
     * @param tooPadding header 的高度
     */
    private void tooPadding(int tooPadding) {
        header.setPadding(header.getPaddingLeft(), tooPadding, header.getPaddingRight(), header.getPaddingBottom());

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//根据firstVisibleItem 可以判断是否在界面最顶端
        this.firstVisibleItem = firstVisibleItem;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
this.scrollState=scrollState;
    }

    /**
     * onTouchEvent 判断手势
     * <p>
     * MotionEvent.ACTION_DOWN  按下
     * <p>
     * MotionEvent.ACTION_MOVE  移动
     * <p>
     * MotionEvent.ACTION_UP    抬起
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (firstVisibleItem == 0) {
                    isRemark=true;
                    startY=(int)ev.getY();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                onMove(ev);

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(ev);
    }
    //判断移动过程中的操作
    private void onMove(MotionEvent ev){
        if(!isRemark){
            return;
        }
        int tempY=(int)ev.getY();
        int space=tempY-startY;
        int topPadding=space-headerHeight;
        switch (state){
            case NONE:
                if(space>0){
                    state=PULL;
                }
                break;
            //下拉时
            case PULL:
                tooPadding(topPadding);
                if(space>headerHeight+30 && scrollState==SCROLL_STATE_TOUCH_SCROLL){

                }
                break;
            case RELESE:
                tooPadding(topPadding);
                if(space<headerHeight+30){
                    state=PULL;
                }else if(space<=0){
                    state=NONE;
                    isRemark=false;
                }


        }
    }
}
