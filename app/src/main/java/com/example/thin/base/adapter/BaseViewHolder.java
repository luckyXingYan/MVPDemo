package com.example.thin.base.adapter;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc:
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <V extends View> V getView(@IdRes int resId) {
        return (V) itemView.findViewById(resId);
    }
}
