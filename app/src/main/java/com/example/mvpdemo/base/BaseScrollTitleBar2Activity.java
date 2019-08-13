package com.example.mvpdemo.base;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;

public abstract class BaseScrollTitleBar2Activity<P extends BasePresenter> extends BaseActivity<P> {
    private NestedScrollView nestedScrollView;
    private FrameLayout frameBottomLayout;
    private View contentView, bottomView;
    protected CollapsingToolbarLayout mTitleBar;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private TextView titleBarTextExpanded, tv_subtitle_expand, tv_subtitle, tv_title;

    @Override
    protected int layoutId() {
        return R.layout.activity_base_scroll_title_bar2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        toolbar = getView(R.id.toolbar);
//        setSupportActionBar(toolbar);
        nestedScrollView = getView(R.id.nsv_content);
        frameBottomLayout = getView(R.id.fl_bottom);
        mTitleBar = getView(R.id.collapsing_toolbar);
        titleBarTextExpanded = getView(R.id.titleBarTextExpanded);
        tv_subtitle_expand = getView(R.id.tv_subtitle_expand);
        tv_subtitle = getView(R.id.tv_subtitle);
        tv_title = getView(R.id.tv_title);
        appBarLayout = getView(R.id.appbar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int scrollRangle = appBarLayout.getTotalScrollRange();
                float alpha = Math.abs(scrollRangle + verticalOffset) / (float) scrollRangle;

                tv_subtitle.setAlpha(1 - alpha);
                tv_title.setAlpha(1 - alpha);

                titleBarTextExpanded.setAlpha(alpha);
                tv_subtitle_expand.setAlpha(alpha);
            }
        });

        //将 contentLayout 装载进 NestedScrollView 中
        contentView = View.inflate(this, getContentLayoutId(), null);
        nestedScrollView.addView(contentView);
        //判断是否显示 bottomLayout 并装载进 FrameLayout 中
        if (bottomLayoutId() != 0) {
            frameBottomLayout.setVisibility(View.VISIBLE);
            bottomView = View.inflate(this, bottomLayoutId(), null);
            frameBottomLayout.addView(bottomView);
        }
        initContentView();
    }

    protected abstract int getContentLayoutId();

    protected int bottomLayoutId() {
        return 0;
    } //底部需要悬浮view的重写此方法 所以写成非抽象的方法

    protected abstract void initContentView();
}
