package com.example.thin.fragment;

import android.view.View;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.iview.IMinePageView;
import com.example.thin.presenter.HomePagePresenter;
import com.example.thin.presenter.MinePagePresenter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MinePageFragment extends BaseFragment<BasePresenter> implements IBaseView {

    public static MinePageFragment newInstance() {
        return new MinePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_mine_page;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public MinePagePresenter createPresenter() {
        return null;
    }
}
