package com.example.mvpdemo.home.iview;

import com.example.mvpdemo.base.IBaseView;
import com.example.mvpdemo.home.bean.HomeDataBean;

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
