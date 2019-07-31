package com.example.mvpdemo.base;


public abstract class BasePresenter<V extends IBaseView> extends MvpBasePresenter<V> {
    public abstract void createModel();//创建对应的model

    public abstract void cancelNetWork();//取消网络请求
}
