package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/16
 * @Desc:
 */
public class FollowPositionActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView {
    private Button next;

    public static void open(Context context) {
        context.startActivity(new Intent(context, FollowPositionActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_follow_position;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("哪一部分最关注的？");
        next = getView(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int bottomLayoutId() {
        return super.bottomLayoutId();
    }
}
