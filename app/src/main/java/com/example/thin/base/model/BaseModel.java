package com.example.thin.base.model;

import com.example.thin.base.bean.ResultBean;
import com.example.thin.base.http.netcore.api.ApiService;
import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.http.netcore.core.NetEngine;

import retrofit2.Call;

/**
 * 作者： 钟雄辉
 * 时间： 2018/6/29
 * 描述： model基类
 **/
public class BaseModel {

    protected ApiService apiService;
    private Call mCall;

    public BaseModel() {
        apiService = NetEngine.getServerApi();
    }

    protected <T> void invoke(Call<ResultBean<T>> call, HttpGsonCallback<T> callBack) {
        mCall = call;
        if (mCall != null) {
            mCall.enqueue(callBack);
        }
    }

    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
}
