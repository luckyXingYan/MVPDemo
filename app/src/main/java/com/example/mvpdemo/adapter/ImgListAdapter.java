package com.example.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvpdemo.R;
import com.example.mvpdemo.activity.RecyclerViewLoopActivity;
import com.example.mvpdemo.base.adapter.BaseRecyclerAdapter;
import com.example.mvpdemo.base.adapter.BaseViewHolder;
import com.example.mvpdemo.bean.DetailDataBean;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc:
 */
public class ImgListAdapter extends BaseRecyclerAdapter<DetailDataBean, ImgListAdapter.MyViewHolder> {
    private Context context;

    public ImgListAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_img_layout;
    }

    @Override
    public int getViewType(int position) {
        return 0;//同样式+多数据
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        DetailDataBean bean = getItemData(position);
        myViewHolder.tv_title.setText(bean.title);
        Glide.with(context).load(bean.imgUrl).into(myViewHolder.iv_icon);
        myViewHolder.btn_loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewLoopActivity.open(context);

            }
        });
    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView tv_title;
        private ImageView iv_icon;
        private Button btn_loop;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = getView(R.id.tv_title);
            iv_icon = getView(R.id.iv_icon);
            btn_loop = getView(R.id.btn_loop);
        }
    }
}
