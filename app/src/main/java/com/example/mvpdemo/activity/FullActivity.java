package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.MvpBasePresenter;

/**
 * [一] 在某些场景下，直接全屏就可以满足客户的需求：比如拍照界面
 */
public class FullActivity extends BaseActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, FullActivity.class));
    }

    @Override
    protected MvpBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        //requestFeature() must be called before adding content
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_full;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        }

    @Override
    protected void initData() {

    }
}
