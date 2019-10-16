package com.example.thin.fragment;

import android.util.Log;
import android.view.View;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.bean.ProductDataBean;
import com.example.thin.iview.IProductPageView;
import com.example.thin.presenter.ProductPagePresenter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class ProductPageFragment extends BaseFragment<ProductPagePresenter> implements IProductPageView {
    private static final String TAG = "ProductPageFragment";

    public static ProductPageFragment newInstance() {
        return new ProductPageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_product_page;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

        if (presenter != null) {
            presenter.getProductPageData("0", "1", getActivity());
        }

    }

    @Override
    public void updateProductData(List<ProductDataBean> data) {
        Log.e(TAG, "updateProductData：" + data.toString());
    }

    @Override
    public ProductPagePresenter createPresenter() {
        return new ProductPagePresenter();
    }
}
