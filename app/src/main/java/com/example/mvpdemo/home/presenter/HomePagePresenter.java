package com.example.mvpdemo.home.presenter;

import android.content.Context;

import com.example.mvpdemo.base.BasePresenter;
import com.example.mvpdemo.base.http.HttpGsonCallback;
import com.example.mvpdemo.home.model.MainPageModel;
import com.example.mvpdemo.home.bean.HomeDataBean;
import com.example.mvpdemo.home.iview.IHomePageView;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class HomePagePresenter extends BasePresenter<IHomePageView> {
    private MainPageModel model;

    //模拟 首页列表
    public void getMainPageData(String start, String count, Context context) {
        model.getMainPageData(start, count, new HttpGsonCallback<List<HomeDataBean>>(context) {

            @Override
            public void onSuccess(List<HomeDataBean> data) {
                if (isViewAttached()) {
                    getView().updateHomeData(data);
                }
            }

            @Override
            public void onBizFailed(int code, String errorMsg) {
                super.onBizFailed(code, errorMsg);
            }
        });
    }

    //模拟 首页广告
    public void getBannerData(String start, String count, Context context) {
        model.getMainPageData(start, count, new HttpGsonCallback<List<HomeDataBean>>(context) {

            @Override
            public void onSuccess(List<HomeDataBean> data) {
                if (isViewAttached()) {
                    getView().updateHomeData(data);
                }
            }

            @Override
            public void onBizFailed(int code, String errorMsg) {
                super.onBizFailed(code, errorMsg);
            }
        });
    }

    @Override
    public void createModel() {
        model = new MainPageModel();
    }

    @Override
    public void cancelNetWork() {
    }
}