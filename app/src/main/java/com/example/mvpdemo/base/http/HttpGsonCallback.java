package com.example.mvpdemo.base.http;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.mvpdemo.base.bean.HttpBean;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Response;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description :
 ************************************************************/
public abstract class HttpGsonCallback<T> extends BaseHttpGsonCallback<T> {

    private WeakReference<Context> context;


    /**
     * @param context 显示弹框和业务跳转使用,特殊情况下可以为null此时只进行网络请求不进行弹窗和业务跳转
     */
    public HttpGsonCallback(@Nullable Context context) {
        this.context = new WeakReference<>(context);
    }


    @Override
    public void onResponse(Call<HttpBean<T>> call, Response<HttpBean<T>> response) {
        super.onResponse(call, response);
        onFinish();

    }


    @Override
    public void onFailure(Call<HttpBean<T>> call, Throwable t) {
        super.onFailure(call, t);
        onFinish();
    }

    @Override
    public void onBizFailed(int code, String errorMsg) {
//        String msg = BuildConfig.DEBUG ? errorMsg + "[" + code + "]" : errorMsg;
//        ToastUtils.showToast(CommonUtils.getApp(), msg);
    }

    @Override
    public void onCookieExpired() {
//        if (!TextUtils.isEmpty(BuildConfig.V_TAG)) {
//            ToastUtils.showToast(CommonUtils.getApp(), "Cookie过期");
//        }
//
//        Context ctx = context == null ? null : context.get();
//        if (!(ctx instanceof Activity)) {
//            return;
//        }
//        AccountManager.reLogin(ctx, true, true);
    }

    @Override
    public void onStopService(String msg) {
//        EventBus.getDefault().post(new StopTakingMsgData(msg));
    }

    @Override
    public void onConnectionFailed() {
//        if (!isShowingDialog) {
//
//            Context ctx = context == null ? null : context.get();
//            if (!(ctx instanceof Activity) || ((Activity) ctx).isFinishing()) {
//                return;
//            }
//
//            msgDialog = new CommonMessageDialog(ctx, CommonMessageDialog.DialogStyle.TIP);
//            msgDialog.setOnDismissListener(this);
//            msgDialog.setOnCancelListener(this);
//            msgDialog.setTitle("提示");
//            msgDialog.setMsg("网络连接异常，请稍后再试");
//            msgDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
//            msgDialog.setTag(null);
//            msgDialog.show();
//            isShowingDialog = true;
//        }
    }


    public void onStart(boolean showProgress) {
//        Context ctx = context == null ? null : context.get();
//        if (!(ctx instanceof Activity) || ((Activity) ctx).isFinishing()) {
//            return;
//        }
//
//        if (showProgress) {
//            if (loadingDialog == null) {
//                loadingDialog = new LoadingDialog(ctx);
//            }
//            if (ctx != null && !((Activity) ctx).isFinishing()) {
//                loadingDialog.show();
//            }
//        }
    }

    public void onFinish() {
//        Context ctx = context == null ? null : context.get();
//        if (!(ctx instanceof Activity) || ((Activity) ctx).isFinishing()) {
//            return;
//        }
//        if (loadingDialog == null) {
//            return;
//        }
//        loadingDialog.dismiss();

    }
}
