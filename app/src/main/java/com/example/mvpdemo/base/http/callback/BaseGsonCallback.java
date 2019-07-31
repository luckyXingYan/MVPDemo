package com.example.mvpdemo.base.http.callback;

import android.util.Log;

import com.example.mvpdemo.base.bean.HttpBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description :
 ************************************************************/
public abstract class BaseGsonCallback<T> implements Callback<HttpBean<T>> {

    @Override
    public void onResponse(Call<HttpBean<T>> call, Response<HttpBean<T>> response) {
        if (response.isSuccessful()) {
            dealResponseSuccess(response.body());
        } else {
            dealResponseFailed(response);
        }
    }

    @Override
    public void onFailure(Call<HttpBean<T>> call, Throwable t) {
        onConnectionFailed();
        t.printStackTrace();
        Log.e("gson,接口调用失败:", t.getMessage());
    }

    private void dealResponseSuccess(HttpBean<T> model) {
        int state = model.getCode();
        switch (state) {
            case HttpBean.STATE_SUCCESS:
                T data = model.getData();
                onSuccess(data);
                break;
            case HttpBean.STATE_FAILURE:
//                HttpBean.ErrorObject error = model.getErrorObj();
//                if (error != null) {
//                    int errorCode = error.getCode();
//                    String errorMsg = error.getMsg();
//                    if (errorCode == ErrorCode.STOP_TAKING_CODE) {
////                        EventBus.getDefault().post(new StopTakingMsgData(errorMsg));
//                    } else if (errorCode == ErrorCode.DEVICE_LOGIN_LIMIT) {
////                        EventBus.getDefault().post(new DeviceLoginLimitExpiredData(errorMsg));
//                    } else {
//                        onBizFailed(errorCode, errorMsg);
//                    }
//                } else {
                onBizFailed(-10, "服务器返回错误");
//                }
                break;
            default:
                onBizFailed(-10, "网络请求失败");
        }

    }

    private void dealResponseFailed(Response<HttpBean<T>> response) {
        Log.i("LOG_HTTP", "[BaseGsonCallback] 接口返回错误 code=" + response.code());
        switch (response.code()) {
            case 401:  //Cookie过期
                onCookieExpired();
                break;
            case 403://停服通知
                onStopService("");
                break;
            case 543:
//                EventBus.getDefault().post(new DeviceLoginLimitExpiredData(""));
                break;
            default: //网络连接异常
                onConnectionFailed();
                break;
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onBizFailed(int code, String errorMsg);

    public abstract void onCookieExpired();

    public abstract void onStopService(String msg);

    public abstract void onConnectionFailed();

}
