package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.ProductDataBean;

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
