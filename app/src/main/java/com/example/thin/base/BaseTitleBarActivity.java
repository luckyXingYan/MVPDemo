package com.example.thin.base;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.view.TitleBar;

public abstract class BaseTitleBarActivity<P extends BasePresenter> extends BaseActivity<P> {

    private FrameLayout frameLayout;
    private View contentView, bottomView;
    public TitleBar titleBar;


    @Override
    protected int layoutId() {
        return R.layout.activity_base_title_bar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleBar = getView(R.id.titleBar);
        frameLayout = getView(R.id.fl_content);

        contentView = View.inflate(this, getContentLayoutId(), null);
        frameLayout.addView(contentView);
        //判断是否显示 bottomLayout 并装载进 FrameLayout 中
        if (bottomLayoutId() != 0) {
            frameLayout.setVisibility(View.VISIBLE);
            bottomView = View.inflate(this, bottomLayoutId(), null);
            frameLayout.addView(bottomView);
        }

        titleBar.setOnBackLinstener(new TitleBar.OnBackListener() {
            @Override
            public void setBack() {
                finish();
            }
        });
        initContentView();
    }


    public void setTitle(String title) {
        titleBar.setTitle(title);
    }


    protected abstract int getContentLayoutId();

    protected int bottomLayoutId() {
        return 0;
    } //底部需要悬浮view的重写此方法 所以写成非抽象的方法

    protected abstract void initContentView();

}
