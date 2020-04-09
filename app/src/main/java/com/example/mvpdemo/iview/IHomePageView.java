package com.example.mvpdemo.iview;

import com.example.mvpdemo.base.mvp.IBaseView;
import com.example.mvpdemo.bean.HomeDataBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IHomePageView extends IBaseView {
    void updateHomeData(List<HomeDataBean> data);

    void updateBannerData(List<HomeDataBean> data);
}
