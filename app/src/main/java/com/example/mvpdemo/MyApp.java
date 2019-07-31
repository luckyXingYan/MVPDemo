package com.example.mvpdemo;

import android.app.Application;

import com.example.mvpdemo.base.http.NetConfig;
import com.example.mvpdemo.base.http.NetEngine;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        // 初始化网络框架
        NetEngine.init(NetConfig.create(this));
        super.onCreate();
    }
}
