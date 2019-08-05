package com.example.mvpdemo;

import android.app.Application;

import com.example.mvpdemo.base.http.netcore.core.NetConfig;
import com.example.mvpdemo.base.http.netcore.core.NetEngine;
import com.squareup.leakcanary.LeakCanary;


/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化网络框架
        NetEngine.init(NetConfig.create(this));
        //初始化内存泄露检测器
        initLeakCanary();
    }

    private void initLeakCanary() {
        //release 版本不检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
