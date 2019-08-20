package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.adapter.LoopImgAdapter;
import com.example.mvpdemo.base.BaseScrollTitleBarActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.util.ScrollLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * [第一步] Item数量控制到最大 == getItemCount   return Integer.MAX_VALUE;
 * [第二步] 获取数据时，计算角标和数据的对应关系（mData是Url数组） == String url = mData.get(position % mData.size());
 * [第三 步] 实现自动滚动 recycleview.scrollToPosition(Integer.MAX_VALUE - 1); 或 recycleview.smoothScrollToPosition(Integer.MAX_VALUE - 1);
 * 第四步：只需要重写LinearLayoutManager的smoothScrollToPosition方法即可控制滚动速度
 */
public class RecyclerViewLoopActivity extends BaseScrollTitleBarActivity<BasePresenter> {

    private RecyclerView recyclerView;
    private LoopImgAdapter adapter;

    public static void open(Context context) {
        context.startActivity(new Intent(context, RecyclerViewLoopActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_recycler_view_loop;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("循环 recyclerView");
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//默认纵向
//        recyclerView.setLayoutManager(linearLayoutManager);

        ScrollLinearLayoutManager scollLinearLayoutManager = new ScrollLinearLayoutManager(this);
        scollLinearLayoutManager.setOrientation(ScrollLinearLayoutManager.HORIZONTAL);
        scollLinearLayoutManager.setSpeedSlow(25);
        recyclerView.setLayoutManager(scollLinearLayoutManager);


        adapter = new LoopImgAdapter(this);
        recyclerView.setAdapter(adapter);

//        recyclerView.scrollToPosition(Integer.MAX_VALUE - 1);//直接滚动到指定位置，没有滚动的动画效果
        recyclerView.smoothScrollToPosition(Integer.MAX_VALUE - 1);//有滚动效果,但是默认速度很快,想可控速度需要重写LinearLayoutManager
    }

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");

        adapter.setData(data);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
