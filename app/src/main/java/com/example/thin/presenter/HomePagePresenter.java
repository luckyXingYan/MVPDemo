package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.model.HomePageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class HomePagePresenter extends BasePresenter<IHomePageView> {
    private HomePageModel model;

    //模拟 首页列表
    public void getHomePageData(String start, String count, Context context) {
        model.getHomePageData(start, count, new HttpGsonCallback<List<HomeDataBean>>(context) {

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
        model.getHomePageData(start, count, new HttpGsonCallback<List<HomeDataBean>>(context) {

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
        model = new HomePageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
