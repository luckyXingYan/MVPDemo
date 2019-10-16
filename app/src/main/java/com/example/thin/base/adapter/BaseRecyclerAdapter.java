package com.example.thin.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.base.util.ToastUtil;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/20
 * @Desc:
 */
public abstract class BaseRecyclerAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    private Context context;
    private List<T> data;
    private OnItemClickListener<T> onItemClickListener;

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
    }

    /**
     * 防止滑动时图片混乱的问题 ==
     * return position ==> viewType = -1 : (同样式+少数据)如果只需要显示一种数据类型，并且数据量不是很大时，推荐将getItemViewType的返回值设置成position，防止紊乱时出现没必要的工作量。
     * return 0 ==> viewType = 0 : (同样式+多数据)如果只需要显示一种数据类型，并且数据量很大时，推荐将getItemViewType的返回值设置成0或者其他固定数值，然后检查代码是否完善（特别注意onBindViewHolder中if-else的代码）
     * 也就是说，如果getItemViewType返回的是固定值时，解决紊乱的问题必须从数据处理着手。
     * return 多类型 ==> viewType = 多 : 如果需要显示多种数据类型，那么getItemViewType的返回值必然会有多种，然后检查代码是否完善（特别注意if-else的代码）
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {//默认返回得是 0
        return getViewType(position);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull final ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(getItemLayout(viewType), viewGroup, false);
        final VH viewHolder = getViewHolder(view, viewType);
        if (onItemClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    if (data.size() > position) {
                        onItemClickListener.onItemClick(viewGroup, v, getItemData(position), position);
                    }
                }
            });
        }
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    //设置数据
    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    //加载更多数据
    public void moreData(List<T> mData) {
        if (data != null) {
            data.addAll(mData);
            notifyItemRangeInserted(data == null ? 0 : data.size(), mData.size());
        }
    }


    public void setItemData(int pos, T data) {
        notifyItemChanged(pos, data);
    }

    public List<T> getData() {
        return data;
    }

    public T getItemData(int pos) {
        if (data != null && data.size() > pos) {
            return data.get(pos);
        }
        return null;
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(ViewGroup parent, View view, T t, int position);
    }

    public abstract int getItemLayout(int viewType);

    public abstract int getViewType(int position);

    public abstract VH getViewHolder(View view, int viewType);

    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(context, msg);
    }


}
