package com.example.thin.fragment;

import android.util.Log;
import android.view.View;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.presenter.HomePagePresenter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements IHomePageView, View.OnClickListener {
    private static final String TAG = "HomePageFragment";

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView(final View view) {
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.getHomePageData("0", "1", getActivity());
            presenter.getBannerData("0", "1", getActivity());
        }
    }

    @Override
    public void updateHomeData(List<HomeDataBean> data) {
        Log.e(TAG, "updateHomeData：" + data.toString());
    }

    @Override
    public void updateBannerData(List<HomeDataBean> data) {
        Log.e(TAG, "updateBannerData：" + data.toString());
    }

    @Override
    public HomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btn_request://CoordinatorLayout
//                SecondActivity.open(getActivity());
//                break;
            default:
                break;
        }
    }
}
