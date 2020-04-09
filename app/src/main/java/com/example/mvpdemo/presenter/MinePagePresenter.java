package com.example.mvpdemo.presenter;

import android.content.Context;

import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.bean.HomeDataBean;
import com.example.mvpdemo.iview.IHomePageView;
import com.example.mvpdemo.model.HomePageModel;
import com.example.mvpdemo.model.MinePageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class MinePagePresenter extends BasePresenter<IHomePageView> {
    private MinePageModel model;

    //模拟 首页列表
    public void getMineInfo(Context context) {
        if (isViewAttached()) {
            getView().updateHomeData(null);
        }
    }

    @Override
    public void createModel() {
        model = new MinePageModel();
    }

    @Override
    public void cancelNetWork() {
    }
}
