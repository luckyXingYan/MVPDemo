package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.adapter.CardViewImgAdapter;
import com.example.mvpdemo.adapter.LoopImgAdapter;
import com.example.mvpdemo.base.BaseScrollTitleBarActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.util.CardScaleHelper;
import com.example.mvpdemo.util.ScrollLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * [第一步] Item数量控制到最大 == getItemCount   return Integer.MAX_VALUE;
 * [第二步] 获取数据时，计算角标和数据的对应关系（mData是Url数组） == String url = mData.get(position % mData.size());
 * [第三 步] 实现自动滚动 recycleview.scrollToPosition(Integer.MAX_VALUE - 1); 或 recycleview.smoothScrollToPosition(Integer.MAX_VALUE - 1);
 * 第四步：只需要重写LinearLayoutManager的smoothScrollToPosition方法即可控制滚动速度
 * <p>
 * RecyclerView 自定义滚动速度 + 借助工具类SnapHelper 实现画廊
 */
public class RecyclerViewLoopActivity extends BaseScrollTitleBarActivity<BasePresenter> {

    private RecyclerView recyclerView, recyclerView2, recyclerView3, recyclerView4;
    private LoopImgAdapter adapter;
    private CardViewImgAdapter cardViewAdapter;

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
        //自定义滚动速度的
        ScrollLinearLayoutManager scollLinearLayoutManager = new ScrollLinearLayoutManager(this);
        scollLinearLayoutManager.setOrientation(ScrollLinearLayoutManager.HORIZONTAL);
        scollLinearLayoutManager.setSpeedSlow(25);
        recyclerView.setLayoutManager(scollLinearLayoutManager);
        adapter = new LoopImgAdapter(this);
        recyclerView.setAdapter(adapter);
//        recyclerView.scrollToPosition(Integer.MAX_VALUE - 1);//直接滚动到指定位置，没有滚动的动画效果
        recyclerView.smoothScrollToPosition(Integer.MAX_VALUE - 1);//有滚动效果,但是默认速度很快,想可控速度需要重写LinearLayoutManager


        /**
         * SnapHelper的使用 2种：
         * 原理的话详见 RecyclerView<第十一篇>：如何自定义RecyclerView
         */
        //LinearSnapHelper 可以让RecyclerView滚动停止时相应的Item停留中间位置（这是典型的画廊效果） 一次能滑多页
        recyclerView2 = getView(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//默认纵向
        recyclerView2.setLayoutManager(linearLayoutManager);
        new LinearSnapHelper().attachToRecyclerView(recyclerView2);
        recyclerView2.setAdapter(adapter);

        //PagerSnapHelper 可以使RecyclerView像ViewPager一样的效果，一次只能滑一页，而且居中显示（这是典型的取代ViewPager方案）
        recyclerView3 = getView(R.id.recyclerView3);
        recyclerView3.setHasFixedSize(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//默认纵向
        recyclerView3.setLayoutManager(manager);
        new PagerSnapHelper().attachToRecyclerView(recyclerView3);
        recyclerView3.setAdapter(adapter);

        //snapHelper 进阶 来优化画廊效果或者类似ViewPager效果。
        recyclerView4 = getView(R.id.recyclerView4);
        recyclerView4.setHasFixedSize(false);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView4.setLayoutManager(manager1);
        cardViewAdapter = new CardViewImgAdapter(this);
        recyclerView4.setAdapter(cardViewAdapter);

        //效果1：中间item的左右两边item没有缩小效果
//        new PagerSnapHelper().attachToRecyclerView(recyclerView4);

        //效果2：中间item的左右两边item有缩小效果
        CardScaleHelper cardScaleHelper = new CardScaleHelper();
        cardScaleHelper.setCurrentItemPos(2);//设置item位置
        cardScaleHelper.attachToRecyclerView(recyclerView4);

        //【第一步】 使用PagerSnapHelper
        //【第二步】 item布局中 引入CardView控件，将图片添加圆形角和阴影效果
        //【第三步】在adapter中设置Item之间的marin和padding 自定义辅助类 CardAdapterHelper
        //【第四步】 将左右两边的Item缩小 通过CardScaleHelper 记得替代第一步的PagerSnapHelper
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
        cardViewAdapter.setData(data);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
