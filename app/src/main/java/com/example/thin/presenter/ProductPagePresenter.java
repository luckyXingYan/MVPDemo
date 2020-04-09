package com.example.thin.presenter;

import android.content.Context;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.bean.ProductDataBean;
import com.example.thin.iview.IProductPageView;
import com.example.thin.model.HomePageModel;
import com.example.thin.model.ProductPageModel;

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
