
package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.bean.DetailDataBean;
import com.example.mvpdemo.iview.IDetailView;
import com.example.mvpdemo.presenter.DetailPresenter;

import java.util.List;


public class SecondActivity extends BaseActivity<DetailPresenter> implements IDetailView {


    private static final String TAG = "SecondActivity";
    private Button btnRequest;

    public static void open(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnRequest = getView(R.id.btn_request);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getInfoData("0", "1", SecondActivity.this);
            }
        });
    }

    private Handler handler = new Handler();

    @Override
    protected void initData() {
//        if (presenter != null) {
//            presenter.getDetailData("0", "1", this);
//        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getDetailData("0", "1", SecondActivity.this);
            }
        }, 3000);
    }

    @Override
    protected DetailPresenter createPresenter() {
        //初始化 presenter
        return new DetailPresenter();
    }

    @Override
    public void updateDetailData(List<DetailDataBean> data) {
        Log.e(TAG, "updateDetailData：" + data.toString());
    }

    @Override
    public void updateInfoData(List<DetailDataBean> data) {
        Log.e(TAG, "updateInfoData：" + data.toString());
    }
}
