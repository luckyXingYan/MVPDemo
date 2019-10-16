package com.example.thin.util;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * @Author: xingyan
 * @Date: 2019/8/21
 * @Desc:
 */
public class ScreenUtil {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        WeakReference<Context> contextWeakReference = new WeakReference<>(context);
        final float scale = contextWeakReference.get().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
