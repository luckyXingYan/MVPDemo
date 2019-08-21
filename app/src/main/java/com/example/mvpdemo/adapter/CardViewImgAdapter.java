package com.example.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mvpdemo.R;
import com.example.mvpdemo.base.adapter.BaseRecyclerAdapter;
import com.example.mvpdemo.base.adapter.BaseViewHolder;
import com.example.mvpdemo.base.util.ToastUtil;
import com.example.mvpdemo.util.CardAdapterHelper;

/**
 * @Author: xingyan
 * @Date: 2019/8/21
 * @Desc:【第三步】 设置Item之间的marin和padding
 * 这里自定义一个辅助类CardAdapterHelper就可以搞定
 */
public class CardViewImgAdapter extends BaseRecyclerAdapter<String, CardViewImgAdapter.MyViewHolder> {
    private Context context;
    private CardAdapterHelper cardAdapterHelper;

    public CardViewImgAdapter(Context context) {
        super(context);
        this.context = context;
        cardAdapterHelper = new CardAdapterHelper();
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_card_view_img_layout;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    /**
     * 因为需要实现美观的画廊 ，所以要手动设置Item之间的marin和padding
     * 即需要重写 onCreateViewHolder 方法
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(getItemLayout(viewType), viewGroup, false);
        cardAdapterHelper.onCreateViewHolder(viewGroup, view);//设置Item之间的marin和padding
        MyViewHolder viewHolder = getViewHolder(view, viewType);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMsg("手动复写onCreateViewHolder方法做item调整");
            }
        });
        return viewHolder;
//        return super.onCreateViewHolder(viewGroup, viewType);
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        cardAdapterHelper.onBindViewHolder(myViewHolder.itemView, i, getItemCount());//设置Item之间的marin和padding
        Glide.with(context).load(getItemData(i)).into(myViewHolder.ivImg);

    }

    protected class MyViewHolder extends BaseViewHolder {

        private ImageView ivImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImg = getView(R.id.iv_bg);
        }
    }


}
