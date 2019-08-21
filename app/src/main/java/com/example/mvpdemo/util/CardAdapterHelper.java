package com.example.mvpdemo.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: xingyan
 * @Date: 2019/8/21
 * @Desc:
 */
public class CardAdapterHelper {
    public void onCreateViewHolder(ViewGroup parent, View itemView) {
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        lp.width = parent.getWidth() - ScreenUtil.dip2px(itemView.getContext(), 2 * (CardScaleConstant.PAGER_PADDING + CardScaleConstant.PAGER_MARGIN));
        itemView.setLayoutParams(lp);
    }

    public void onBindViewHolder(View itemView, final int position, int itemCount) {
        int padding = ScreenUtil.dip2px(itemView.getContext(), CardScaleConstant.PAGER_PADDING);
        itemView.setPadding(padding, 0, padding, 0);
        int leftMarin = position == 0 ? padding + ScreenUtil.dip2px(itemView.getContext(), CardScaleConstant.PAGER_MARGIN) : 0;
        int rightMarin = position == itemCount - 1 ? padding + ScreenUtil.dip2px(itemView.getContext(), CardScaleConstant.PAGER_MARGIN) : 0;
        setViewMargin(itemView, leftMarin, 0, rightMarin, 0);
    }

    private void setViewMargin(View view, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (lp.leftMargin != left || lp.topMargin != top || lp.rightMargin != right || lp.bottomMargin != bottom) {
            lp.setMargins(left, top, right, bottom);
            view.setLayoutParams(lp);
        }
    }

    /**
     * 自定义 item 的 padding 默认25
     *
     * @param pagePadding
     */
    public void setPagePadding(int pagePadding) {
        CardScaleConstant.PAGER_PADDING = pagePadding;
    }

    /**
     * 自定义 item 的 margin 默认25
     *
     * @param pagerMargin
     */
    public void setPageMarin(int pagerMargin) {
        CardScaleConstant.PAGER_MARGIN = pagerMargin;
    }
}
