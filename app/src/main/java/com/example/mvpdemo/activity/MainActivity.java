package com.example.mvpdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.base.mvp.IBaseView;
import com.example.mvpdemo.fragment.HomePageFragment;
import com.example.mvpdemo.fragment.MinePageFragment;
import com.example.mvpdemo.fragment.ProductPageFragment;
import com.example.mvpdemo.view.MainBottomTabView;
import com.example.mvpdemo.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<BasePresenter<IBaseView>> {

    private static final String TAG = "MainActivity";
    private NoScrollViewPager noScrollViewPager;
    private TabLayout tabLayout;
    private List<Fragment> mFrags;
    private MainBottomTabView tab1, tab2, tab3;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        noScrollViewPager = getView(R.id.noScrollViewPager);
        tabLayout = getView(R.id.tabLayout);

        mFrags = new ArrayList<>();
        mFrags.add(HomePageFragment.newInstance());
        mFrags.add(ProductPageFragment.newInstance());
        mFrags.add(MinePageFragment.newInstance());

        tab1 = new MainBottomTabView(this).setTvTabTitle("首页");
        tab2 = new MainBottomTabView(this).setTvTabTitle("产品");
        tab3 = new MainBottomTabView(this).setTvTabTitle("我的");

        noScrollViewPager.setOffscreenPageLimit(mFrags.size());
        noScrollViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFrags.get(i);
            }

            @Override
            public int getCount() {
                return mFrags.size();
            }
        });
        tabLayout.setupWithViewPager(noScrollViewPager);

        tabLayout.getTabAt(0).setCustomView(tab1);
        tabLayout.getTabAt(1).setCustomView(tab2);
        tabLayout.getTabAt(2).setCustomView(tab3);

    }

    @Override
    protected void initData() {
    }


    @Override
    protected BasePresenter<IBaseView> createPresenter() {
        return null;
    }
}
