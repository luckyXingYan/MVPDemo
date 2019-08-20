package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.adapter.ImgListAdapter;
import com.example.mvpdemo.base.BaseScrollTitleBarActivity;
import com.example.mvpdemo.base.adapter.RecyclerViewDivider;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.MvpBaseActivity;
import com.example.mvpdemo.bean.DetailDataBean;
import com.example.mvpdemo.iview.IDetailView;
import com.example.mvpdemo.presenter.DetailPresenter;

import java.util.List;

public class RecyclerViewActivity2 extends BaseActivity<DetailPresenter> implements IDetailView {

    private RecyclerView recyclerView;
    private ImgListAdapter adapter;

    public static void open(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity2.class);
        context.startActivity(intent);
    }

    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter();
    }

    @Override
    public void updateDetailData(List<DetailDataBean> data) {
        data.get(0).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(1).imgUrl = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
        data.get(2).imgUrl = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
        data.get(3).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(4).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(5).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(6).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(7).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(8).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        data.get(9).imgUrl = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        adapter.setData(data);
    }

    @Override
    public void updateInfoData(List<DetailDataBean> data) {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        //可组合
        recyclerView.addItemDecoration(new RecyclerViewDivider(80));
//        recyclerView.addItemDecoration(new RecyclerViewDivider(80));

        adapter = new ImgListAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        presenter.getDetailData("0", "10", this);
    }
}
