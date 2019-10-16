package com.example.thin.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/16
 * @Desc:
 */
public class TitleBar extends LinearLayout {
    private ConstraintLayout constraintLayout;
    private ImageView back;
    private TextView titleTv, rightTxt;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_titlebar, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        constraintLayout = findViewById(R.id.cl_title_bar);
        back = findViewById(R.id.iv_left_back);
        titleTv = findViewById(R.id.tv_main_title);
        rightTxt = findViewById(R.id.tv_right_title);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                backListener.setBack();
            }
        });
    }

    public void setTitle(String title) {
        titleTv.setText(title);
    }

    public void setRightTxt(String txt) {
        rightTxt.setText(txt);
    }

    public void setTitleBarGone() {
        constraintLayout.setVisibility(GONE);
    }

    public void setRightTxtVisible() {
        rightTxt.setVisibility(VISIBLE);
    }


    private OnBackListener backListener;

    public interface OnBackListener {
        void setBack();
    }

    public void setOnBackLinstener(OnBackListener backListener) {
        this.backListener = backListener;
    }
}
