package com.example.mvpdemo.base.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc: 绘制 RecyclerView 的分割线 ==> mRecyclerView.addItemDecoration(new RecyclerViewDivider(10));
 * ==== getItemOffsets和onDrawOver结合实现粘贴头部效果,越来越多的项目中运用(绘制分组的头部)
 * Item的粘性头部和顶部悬浮的效果.
 * <p>
 * <p>
 * 注意：悬浮效果不能用在继承 BaseScrollTitleBarActivity 的 activity 中
 */
public class RecyclerViewDivider extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint paint;
    private Paint.FontMetrics fontMetrics;

    public RecyclerViewDivider(int dividerHeight) {
        this.dividerHeight = dividerHeight;

        paint = new Paint();
        paint.setTextSize(50);
        fontMetrics = paint.getFontMetrics();
    }

    /**
     * 实现类似margin的效果,设置Item的布局四周的间隔.
     *
     * @param outRect 确定间隔 Left  Top Right Bottom 数值的矩形.
     * @param view    RecyclerView的ChildView也就是每个Item的的布局.
     * @param parent  RecyclerView本身.
     * @param state   RecyclerView的各种状态.
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        outRect.set(0, 0, 0, dividerHeight);//类似于给item的根布局加android:layout_marginBottom="10dp"
//        outRect.set(0, dividerHeight, 0, 0);//类似于给item的根布局加android:layout_marginBottom="10dp"
        outRect.top = dividerHeight;
    }

    /**
     * 添加Item的背景,Item的内容绘制之前执行,配合getItemOffsets来绘制分割线
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    /**
     * Item上方绘制（矩形，圆形，路径，文字等）
     * 如果该项已读，那么在右边显示一个已读图片。（当然，也可以作为分割线显示在Item的上方）
     * Item的内容绘制之后执行,一般配合getItemOffsets来绘制分组的头部
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            //核心代码--start---
            int left = child.getLeft();
            int right = child.getRight();
            int bottom = child.getBottom();
            int top = Math.max(dividerHeight, child.getTop());

            if (position + 1 < itemCount) {
                if (bottom < top) {
                    top = bottom;
                }
            }
            //核心代码--end---

            paint.setColor(Color.GRAY);
            c.drawRect(left, top - dividerHeight, right, top, paint);
            paint.setColor(Color.parseColor("#ffffff"));
            c.drawText("类型AAAAAg", left + 10, top - fontMetrics.descent - (dividerHeight - fontMetrics.bottom + fontMetrics.top) / 2, paint);
        }
    }
}
