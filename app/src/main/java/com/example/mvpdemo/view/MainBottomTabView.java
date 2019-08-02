package com.example.mvpdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvpdemo.R;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MainBottomTabView extends RelativeLayout {
    private TextView tvTabTitle;
    private String mTitle;


    public MainBottomTabView(Context context) {
        this(context, null);
    }

    public MainBottomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.widget_main_bottom_tabview, this);
        tvTabTitle = (TextView) findViewById(R.id.tv_tab_title);
    }

    public MainBottomTabView setTvTabTitle(String title) {
        this.mTitle = title;
        tvTabTitle.setText(mTitle);
        return this;
    }
}
