package com.example.mvpdemo.util;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc:
 */
public class ScrollLinearLayoutManager extends LinearLayoutManager {
    private float MILLISECONDS_PER_INCH = 25f;  //修改可以改变数据,越大速度越慢
    private Context context;

    public ScrollLinearLayoutManager(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return ScrollLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.density; //返回滑动一个pixel需要多少毫秒
            }

        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    //可以用来设置速度
    public void setSpeedSlow(float x) {
        MILLISECONDS_PER_INCH = context.getResources().getDisplayMetrics().density * 0.3f + (x);
    }
}
