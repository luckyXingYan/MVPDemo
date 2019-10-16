package com.example.thin.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.fragment.HomePageFragment;
import com.example.thin.fragment.MinePageFragment;
import com.example.thin.fragment.MinePageFragment2;
import com.example.thin.fragment.ProductPageFragment;
import com.example.thin.view.MainBottomTabView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<BasePresenter<IBaseView>> {

    private static final String TAG = "MainActivity";
    private List<Fragment> mFrags = new ArrayList<>();
    private MainBottomTabView mainBottomTabView;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        mainBottomTabView = getView(R.id.mainBottomTabView);

        mFrags.add(HomePageFragment.newInstance());
        mFrags.add(ProductPageFragment.newInstance());
        mFrags.add(MinePageFragment.newInstance());
        mFrags.add(MinePageFragment2.newInstance());

//        默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,
                mFrags.get(0)).commit();

        mainBottomTabView.setSelectFragmentInterface(new MainBottomTabView.SelectFragmentLinstener() {
            @Override
            public void selectFragment(int index) {
                //切换tab
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        mFrags.get(index)).commit();
            }
        });


    }

    @Override
    protected void initData() {
    }


    @Override
    protected BasePresenter<IBaseView> createPresenter() {
        return null;
    }
}
