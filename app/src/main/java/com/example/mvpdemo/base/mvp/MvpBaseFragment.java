package com.example.mvpdemo.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public abstract class MvpBaseFragment<P extends MvpBasePresenter> extends Fragment implements IMvpBaseView {
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected <V extends View> V getView(View view, int resId) {
        return (V) view.findViewById(resId);
    }

    public abstract P createPresenter();
}
