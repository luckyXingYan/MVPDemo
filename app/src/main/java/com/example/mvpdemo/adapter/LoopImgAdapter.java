package com.example.mvpdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mvpdemo.R;
import com.example.mvpdemo.base.adapter.BaseRecyclerAdapter;
import com.example.mvpdemo.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc:
 */
public class LoopImgAdapter extends BaseRecyclerAdapter<String, LoopImgAdapter.MyViewHolder> {

    private Context context;

    public LoopImgAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_loop_img_layout;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

//        String url = getItemData(i);
        String url = getItemData(i % getData().size());//控制滚动的关键，从第几个位置到第几个位置展示图片
        Glide.with(context).load(url).into(myViewHolder.iv_loop);

    }

    protected class MyViewHolder extends BaseViewHolder {

        private ImageView iv_loop;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_loop = getView(R.id.iv_loop);
        }
    }
}
