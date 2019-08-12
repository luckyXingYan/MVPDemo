package com.example.mvpdemo.base;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.FrameLayout;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;

public abstract class BaseScrollTitleBarActivity<P extends BasePresenter> extends BaseActivity<P> {

    private NestedScrollView nestedScrollView;
    private FrameLayout frameBottomLayout;
    private View contentView, bottomView;


    @Override
    protected int layoutId() {
        return R.layout.activity_base_scroll_title_bar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        nestedScrollView = getView(R.id.nsv_content);
        frameBottomLayout = getView(R.id.fl_bottom);

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
