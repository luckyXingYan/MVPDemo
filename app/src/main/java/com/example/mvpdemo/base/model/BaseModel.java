package com.example.mvpdemo.base.model;

import com.example.mvpdemo.base.bean.ResultBean;
import com.example.mvpdemo.base.http.netcore.api.ApiService;
import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.http.netcore.core.NetEngine;


import retrofit2.Call;

/**
 * 作者： 钟雄辉
 * 时间： 2018/6/29
 * 描述： model基类
 **/
public class BaseModel {

    protected ApiService apiService;

    public BaseModel() {
        apiService = NetEngine.getServerApi();
    }

    protected <T> void invoke(Call<ResultBean<T>> call, HttpGsonCallback<T> callBack) {
//        if (mCall != null) {
//            mCall.enqueue(callBack);
//        }
        call.enqueue(callBack);

    }

    public void cancel() {
//        if (mCall != null) {
//            mCall.cancel();
//        }
    }
}
