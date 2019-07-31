package com.example.mvpdemo.base;


public interface IBaseView extends IMvpBaseView {
    void showNetworkErrorDialog();

    void showLoadingDialog();

    void dismissLoadingDialog();

    void showToastMsg(String msg);
}
