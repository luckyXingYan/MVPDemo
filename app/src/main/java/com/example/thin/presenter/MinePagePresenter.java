package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.model.HomePageModel;
import com.example.thin.model.MinePageModel;

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
        model.cancel();
    }
}
