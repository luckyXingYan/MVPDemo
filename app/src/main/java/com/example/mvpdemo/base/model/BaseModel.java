package com.example.mvpdemo.base.model;

import com.example.mvpdemo.base.api.ApiService;
import com.example.mvpdemo.base.bean.HttpBean;
import com.example.mvpdemo.base.http.HttpGsonCallback;
import com.example.mvpdemo.base.http.NetEngine;


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

    protected <T> void invoke(Call<HttpBean<T>> call, HttpGsonCallback<T> callBack) {
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
