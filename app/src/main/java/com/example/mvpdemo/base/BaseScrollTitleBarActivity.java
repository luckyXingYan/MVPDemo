package com.example.mvpdemo.base;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;

public abstract class BaseScrollTitleBarActivity<P extends BasePresenter> extends BaseActivity<P> {

    private NestedScrollView nestedScrollView;
    private FrameLayout frameBottomLayout;
    private View contentView, bottomView;
    protected CollapsingToolbarLayout mTitleBar;
    private Toolbar toolbar;
    private ImageView backTitleBar;


    @Override
    protected int layoutId() {
        return R.layout.activity_base_scroll_title_bar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        toolbar = getView(R.id.toolbar);
        setSupportActionBar(toolbar);

        nestedScrollView = getView(R.id.nsv_content);
        frameBottomLayout = getView(R.id.fl_bottom);
        mTitleBar = getView(R.id.collapsing_toolbar);
        backTitleBar = getView(R.id.iv_back_titleBar);

        //将 contentLayout 装载进 NestedScrollView 中
        contentView = View.inflate(this, getContentLayoutId(), null);
        nestedScrollView.addView(contentView);
        //判断是否显示 bottomLayout 并装载进 FrameLayout 中
        if (bottomLayoutId() != 0) {
            frameBottomLayout.setVisibility(View.VISIBLE);
            bottomView = View.inflate(this, bottomLayoutId(), null);
            frameBottomLayout.addView(bottomView);
        }

        backTitleBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initContentView();
    }

    protected abstract int getContentLayoutId();

    protected int bottomLayoutId() {
        return 0;
    } //底部需要悬浮view的重写此方法 所以写成非抽象的方法

    protected abstract void initContentView();

}
