package com.example.mvpdemo.iview;

import com.example.mvpdemo.base.mvp.IBaseView;
import com.example.mvpdemo.bean.ProductDataBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IProductPageView extends IBaseView {
    void updateProductData(List<ProductDataBean> data);
}
