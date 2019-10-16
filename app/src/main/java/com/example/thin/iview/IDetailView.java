package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.DetailDataBean;

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
