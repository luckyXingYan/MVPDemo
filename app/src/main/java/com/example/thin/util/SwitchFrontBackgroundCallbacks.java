package com.example.thin.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * @Author: xingyan
 * @Date: 2019/8/15
 * @Desc: ActivityLifeCycleCallback在Application中注册监听
 * 1、不仅可以管理Activity，
 * 2、还可以监听前后台切换的变化
 */
@SuppressLint("LongLogTag")
public class SwitchFrontBackgroundCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "---SwitchFrontBackgroundCallbacks";

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e(TAG, "onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.e(TAG, "onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e(TAG, "onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e(TAG, "onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.e(TAG, "onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG, "onActivityDestroyed");
    }
}
