package com.example.mvpdemo.presenter;

import android.content.Context;

import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.bean.HomeDataBean;
import com.example.mvpdemo.bean.ProductDataBean;
import com.example.mvpdemo.iview.IProductPageView;
import com.example.mvpdemo.model.HomePageModel;
import com.example.mvpdemo.model.ProductPageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class ProductPagePresenter extends BasePresenter<IProductPageView> {
    private ProductPageModel model;

    public void getProductPageData(String start, String count, Context context) {
        model.getProductPageData(start, count, new HttpGsonCallback<List<ProductDataBean>>(context) {

            @Override
            public void onSuccess(List<ProductDataBean> data) {
                if (isViewAttached()) {
                    getView().updateProductData(data);
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
        model = new ProductPageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
