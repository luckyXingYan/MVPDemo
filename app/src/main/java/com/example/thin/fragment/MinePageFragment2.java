package com.example.thin.fragment;

import android.view.View;

import com.example.thin.R;
import com.example.thin.activity.FollowPositionActivity;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.presenter.MinePagePresenter;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MinePageFragment2 extends BaseFragment<BasePresenter> implements IBaseView {

    public static MinePageFragment2 newInstance() {
        return new MinePageFragment2();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_mine_page2;
    }

    @Override
    protected void initView(View view) {

        getView(view, R.id.btn_follow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FollowPositionActivity.open(getActivity());
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public MinePagePresenter createPresenter() {
        return null;
    }
}
