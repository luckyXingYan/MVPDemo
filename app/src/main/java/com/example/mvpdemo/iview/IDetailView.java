package com.example.mvpdemo.iview;

import com.example.mvpdemo.base.mvp.IBaseView;
import com.example.mvpdemo.bean.DetailDataBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public interface IDetailView extends IBaseView {
    void updateDetailData(List<DetailDataBean> data);
    void updateInfoData(List<DetailDataBean> data);
}
