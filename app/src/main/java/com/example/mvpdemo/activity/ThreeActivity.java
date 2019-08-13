package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.BaseScrollTitleBar2Activity;
import com.example.mvpdemo.base.mvp.BasePresenter;

public class ThreeActivity extends BaseScrollTitleBar2Activity<BasePresenter> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ThreeActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_three;
    }

    @Override
    protected int bottomLayoutId() {
        return R.layout.common_bottom_layout;
    }

    @Override
    protected void initContentView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
