package com.example.mvpdemo.model;

import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.model.BaseModel;
import com.example.mvpdemo.bean.ProductDataBean;

import java.util.List;

/**
 * @Author: Mr.Z
 * @Date: 2018/9/20
 * @Desc:
 */
public class ProductPageModel extends BaseModel {
    public void getProductPageData(String start, String count, HttpGsonCallback<List<ProductDataBean>> callback) {
        invoke(apiService.getProductPageData(start, count), callback);
    }
}
