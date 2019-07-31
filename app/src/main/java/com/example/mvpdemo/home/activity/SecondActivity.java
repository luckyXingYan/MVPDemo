
package com.example.mvpdemo.home.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.BaseActivity;
import com.example.mvpdemo.home.bean.HomeDataBean;
import com.example.mvpdemo.home.iview.IHomePageView;
import com.example.mvpdemo.home.presenter.HomePagePresenter;

import java.util.List;

public class SecondActivity extends BaseActivity<HomePagePresenter> implements IHomePageView {


    private static final String TAG = "SecondActivity";
    private Button btnRequest;


    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {


        btnRequest = (Button) findViewById(R.id.btn_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getBannerData("0", "2", SecondActivity.this);
            }
        });

        if (presenter != null) {
            //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
            presenter.getMainPageData("0", "2", this);
        }
    }

    @Override
    protected HomePagePresenter createPresenter() {
        //初始化 presenter
        return new HomePagePresenter();
    }

    @Override
    public void updateHomeData(List<HomeDataBean> data) {
        Log.e(TAG, "updateHomeData：" + data.toString());
    }

    @Override
    public void updateBannerData(List<HomeDataBean> data) {
        Log.e(TAG, "updateBannerData：" + data.toString());
    }
}
