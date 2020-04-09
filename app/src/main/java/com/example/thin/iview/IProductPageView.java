package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.ProductDataBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IProductPageView extends IBaseView {
    void updateProductData(List<ProductDataBean> data);
}
