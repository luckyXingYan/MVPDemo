package com.example.mvpdemo.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.activity.FullActivity;
import com.example.mvpdemo.activity.SecondActivity;
import com.example.mvpdemo.base.mvp.BaseFragment;
import com.example.mvpdemo.bean.HomeDataBean;
import com.example.mvpdemo.iview.IHomePageView;
import com.example.mvpdemo.presenter.HomePagePresenter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements IHomePageView {
    private static final String TAG = "HomePageFragment";
    private Button btnRequest, btnFull;


    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView(final View view) {
        btnRequest = getView(view, R.id.btn_request);
        btnFull = getView(view, R.id.btn_full);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.open(getActivity());
            }
        });

        /**
         * 沉浸式导航栏
         * 导航栏分为顶部状态栏和底部虚拟键盘，导航栏沉浸式在Android 4.4之后被推出
         */
        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //[一] 在某些场景下，直接全屏就可以满足客户的需求：比如拍照界面
                FullActivity.open(getActivity());
            }
        });
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
}
