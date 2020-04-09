package com.example.mvpdemo.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mvpdemo.base.util.AppManager;
import com.example.mvpdemo.base.util.ToastUtil;

/**
 * 作者： 钟雄辉
 * 时间： 2018/6/27
 * 描述： 放置公共业务的Activity
 **/
public abstract class BaseActivity<P extends BasePresenter> extends MvpBaseActivity<P> implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(layoutId());
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
        if (presenter != null) {
            presenter.cancelNetWork();
        }
    }

    @Override
    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(this, msg);
    }

    protected abstract int layoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();
}
