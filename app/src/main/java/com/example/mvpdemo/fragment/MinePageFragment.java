package com.example.mvpdemo.fragment;

import android.view.View;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseFragment;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.base.mvp.IBaseView;
import com.example.mvpdemo.bean.HomeDataBean;
import com.example.mvpdemo.iview.IHomePageView;
import com.example.mvpdemo.iview.IMinePageView;
import com.example.mvpdemo.presenter.HomePagePresenter;
import com.example.mvpdemo.presenter.MinePagePresenter;

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
