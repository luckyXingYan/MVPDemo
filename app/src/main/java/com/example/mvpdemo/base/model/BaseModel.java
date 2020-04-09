package com.example.mvpdemo.base.model;

import com.example.mvpdemo.base.bean.ResultBean;
import com.example.mvpdemo.base.http.netcore.api.ApiService;
import com.example.mvpdemo.base.http.callback.HttpGsonCallback;
import com.example.mvpdemo.base.http.netcore.core.NetEngine;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
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

//
//        Observable.create(new ObservableOnSubscribe<ResultBean<T>>() {
//            @Override
//            public void subscribe(ObservableEmitter<ResultBean<T>> emitter) throws Exception {
//
//            }
//        }).subscribe(new Observer<ResultBean<T>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(ResultBean<T> tResultBean) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }

    public void cancel() {
//        if (mCall != null) {
//            mCall.cancel();
//        }
    }
}
