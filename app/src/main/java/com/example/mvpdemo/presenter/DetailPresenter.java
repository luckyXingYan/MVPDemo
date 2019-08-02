package com.example.mvpdemo.presenter;

import android.content.Context;

import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.bean.DetailDataBean;
import com.example.mvpdemo.iview.IDetailView;
import com.example.mvpdemo.model.HomePageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class DetailPresenter extends BasePresenter<IDetailView> {
    private HomePageModel model;

    //模拟 详情
    public void getDetailData(String start, String count, Context context) {
        model.getDetailData(start, count, new HttpGsonCallback<List<DetailDataBean>>(context) {

            @Override
            public void onSuccess(List<DetailDataBean> data) {
                if (isViewAttached()) {
                    getView().updateDetailData(data);
                }
            }

            @Override
            public void onBizFailed(int code, String errorMsg) {
                super.onBizFailed(code, errorMsg);
            }
        });
    }

    public void getInfoData(String start, String count, Context context) {
        model.getInfoData(start, count, new HttpGsonCallback<List<DetailDataBean>>(context) {

            @Override
            public void onSuccess(List<DetailDataBean> data) {
                if (isViewAttached()) {
                    getView().updateInfoData(data);
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
    }
}
