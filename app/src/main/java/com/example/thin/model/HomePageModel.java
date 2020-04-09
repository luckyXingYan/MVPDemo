package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.DetailDataBean;
import com.example.thin.bean.HomeDataBean;

import java.util.List;

/**
 * @Author: Mr.Z
 * @Date: 2018/9/20
 * @Desc:
 */
public class HomePageModel extends BaseModel {

    //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
    public void getHomePageData(String start, String count, HttpGsonCallback<List<HomeDataBean>> callback) {
//        callback.onStart(false);//可以参数形式传进来，是否显示加载框，默认false
        invoke(apiService.getHomePageData(start, count), callback);
    }

    public void getDetailData(String start, String count, HttpGsonCallback<List<DetailDataBean>> callback) {
        invoke(apiService.getDetailData(start, count), callback);
    }

    public void getInfoData(String start, String count, HttpGsonCallback<List<DetailDataBean>> callback) {
        invoke(apiService.getInfoData(start, count), callback);
    }

}
